package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.Copy;
import com.arobs.internship.library.entity.RentRequest;
import com.arobs.internship.library.entity.dto.RentRequestDto;
import com.arobs.internship.library.entity.dto.viewer.RentRequestDtoViewer;
import com.arobs.internship.library.entity.helper.StatusCopy;
import com.arobs.internship.library.entity.helper.StatusRentRequest;
import com.arobs.internship.library.exceptions.EntityMustNotBeModifiedException;
import com.arobs.internship.library.exceptions.LimitedAccessException;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.mapper.hibernate.RentRequestMapper;
import com.arobs.internship.library.notification.EmployeeNotification;
import com.arobs.internship.library.repository.RentRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentRequestService {
    private static final Logger log = LoggerFactory.getLogger(RentRequestService.class);

    @Autowired
    private RentRequestRepository rentRequestRepository;
    @Autowired
    private RentRequestMapper rentRequestMapper;
    @Autowired
    private BookService bookService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BookRentService bookRentService;
    @Autowired
    private CopyService copyService;
    @Autowired
    private EmployeeNotification employeeNotification;

    @Transactional(readOnly = true)
    public RentRequestDtoViewer getRentRequestDto(Integer id) {
        return rentRequestMapper.toDtoViewer(getRentRequestById(id));
    }

    @Transactional(readOnly = true)
    public List<RentRequestDtoViewer> getAllRentRequestDtos() {
        return rentRequestMapper.toListDtoViewers(rentRequestRepository.findAll());
    }

    @Transactional
    public RentRequestDtoViewer addRentRequestDto(RentRequestDto rentRequestDto) {
        if (employeeService.getEmployeeById(rentRequestDto.getIdEmployee()).isBanned()) {
            throw new LimitedAccessException("A book rent cannot be created because this employee is banned",
                    rentRequestDto.getIdEmployee());
        }
        rentRequestDto.setStatus(StatusRentRequest.WAITING_FOR_AVAILABLE);
        return rentRequestMapper.toDtoViewer(rentRequestRepository.save(rentRequestMapper.toEntity(rentRequestDto, bookService, employeeService)));
    }

    @Transactional
    public RentRequestDtoViewer editRentRequestDto(RentRequestDto rentRequestDto) {
        RentRequest rentRequestToEdit = getRentRequestById(rentRequestDto.getId());
        return rentRequestMapper.toDtoViewer(rentRequestMapper.updateEntity(rentRequestToEdit, rentRequestDto, bookService, employeeService));
    }

    @Transactional
    public RentRequestDtoViewer deleteRentRequest(int id) {
        RentRequest rentRequest = getRentRequestById(id);
        if (rentRequest.getStatus().equals(StatusRentRequest.WAITING_FOR_CONFIRMATION)) {
            Copy copy = copyService.getCopyByBookIdAndStatus(rentRequest.getBook().getId(), StatusCopy.PENDING);
            copy.setStatus(StatusCopy.AVAILABLE);
        }
        rentRequestRepository.delete(rentRequest);
        return rentRequestMapper.toDtoViewer(rentRequest);
    }

    @Transactional(readOnly = true)
    public List<RentRequestDtoViewer> getAllRentRequestByBookId(Integer bookId) {
        return rentRequestMapper.toListDtoViewers(rentRequestRepository.findByBookIdOrderByRequestDateAsc(bookId));
    }

    @Transactional(readOnly = true)
    public List<RentRequestDtoViewer> getAllRentRequestDtosByBookIdAndStatus(Integer idBook, StatusRentRequest statusRentRequest) {
        return rentRequestMapper.toListDtoViewers(getAllRentRequestByBookIdAndStatus(idBook, statusRentRequest));
    }

    @Transactional
    public RentRequestDtoViewer acceptRentRequestById(Integer id, Integer idEmployee) {
        RentRequest rentRequest = getRentRequestForStatusChange(id, idEmployee);
        rentRequest.setStatus(StatusRentRequest.GRANTED);
        rentRequest.setBookRent(bookRentService.createBookRentFromRentRequest(rentRequest.getBook().getId(),
                rentRequest.getEmployee().getId()));
        return rentRequestMapper.toDtoViewer(rentRequest);
    }

    @Transactional
    public RentRequestDtoViewer declineRentRequestById(Integer id, Integer idEmployee) {
        RentRequest rentRequest = getRentRequestForStatusChange(id, idEmployee);
        rentRequest.setStatus(StatusRentRequest.DECLINED);
        Copy copy = copyService.getCopyByBookIdAndStatus(rentRequest.getBook().getId(), StatusCopy.PENDING);
        getNextRentRequest(rentRequest.getBook().getId(), copy)
                .ifPresent(request -> {
                    employeeNotification.notifyForCopyAvailable(request);
                    request.setRequestDate(LocalDateTime.now());
                });
        return rentRequestMapper.toDtoViewer(rentRequest);
    }

    @Transactional(readOnly = true)
    public List<RentRequest> getAllRentRequestByBookIdAndStatus(Integer idBook,
                                                                StatusRentRequest statusRentRequest) {
        return rentRequestRepository.findByBookIdAndStatusOrderByRequestDateAsc(idBook, statusRentRequest);
    }

    @Transactional(readOnly = true)
    public List<RentRequestDtoViewer> getAllRentRequestByEmployeeId(Integer id) {
        return rentRequestMapper.toListDtoViewers(rentRequestRepository.findAllByEmployeeId(id));
    }

    @Transactional(readOnly = true)
    public List<RentRequest> getAllByStatusAndRequestDateLessThanEqual(StatusRentRequest statusRentRequest,
                                                                       LocalDateTime date) {
        return rentRequestRepository.findAllByStatusAndRequestDateLessThanEqual(statusRentRequest, date);
    }

    @Transactional
    public Optional<RentRequest> getNextRentRequest(Integer idBook, Copy copy) {
        List<RentRequest> rentRequests = getAllRentRequestByBookIdAndStatus(idBook, StatusRentRequest.WAITING_FOR_AVAILABLE);
        if (rentRequests.size() > 0) {
            RentRequest rentRequest = rentRequests.get(0);
            rentRequest.setStatus(StatusRentRequest.WAITING_FOR_CONFIRMATION);
            copy.setStatus(StatusCopy.PENDING);
            return Optional.of(rentRequest);
        }
        copy.setStatus(StatusCopy.AVAILABLE);
        return Optional.empty();
    }

    protected RentRequest getRentRequestById(Integer id) {
        return rentRequestRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("Could not find rent request with id {}", id);
                    return new NoDataFoundException("This rent request could not be found", id);
                });
    }

    private RentRequest getRentRequestForStatusChange(Integer id, Integer idEmployee) {
        RentRequest rentRequest = getRentRequestById(id);
        if (!rentRequest.getStatus().equals(StatusRentRequest.WAITING_FOR_CONFIRMATION)) {
            throw new NoDataFoundException("This rental request is not awaiting confirmation", id);
        }
        if (!rentRequest.getEmployee().getId().equals(idEmployee)) {
            throw new EntityMustNotBeModifiedException("This request for rent does not belong to the employee with id: " + idEmployee, id);
        }
        return rentRequest;
    }
}
