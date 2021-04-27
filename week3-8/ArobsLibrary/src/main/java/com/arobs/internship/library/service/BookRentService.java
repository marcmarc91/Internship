package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.BookRent;
import com.arobs.internship.library.entity.Copy;
import com.arobs.internship.library.entity.dto.BookRentDto;
import com.arobs.internship.library.entity.dto.viewer.BookRentDtoViewer;
import com.arobs.internship.library.entity.types.StatusBookRent;
import com.arobs.internship.library.entity.types.StatusCopy;
import com.arobs.internship.library.exceptions.EntityMustNotBeModifiedException;
import com.arobs.internship.library.exceptions.ExtensionPeriodLimitExceededException;
import com.arobs.internship.library.exceptions.LimitedAccessException;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.mapper.hibernate.BookRentMapper;
import com.arobs.internship.library.notification.EmployeeNotification;
import com.arobs.internship.library.repository.BookRentRepository;
import com.arobs.internship.library.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookRentService {
    private static final Logger log = LoggerFactory.getLogger(BookRentService.class);

    @Autowired
    private BookRentRepository bookRentRepository;
    @Autowired
    private BookRentMapper bookRentMapper;
    @Autowired
    private RentRequestService rentRequestService;
    @Autowired
    private CopyService copyService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BookService bookService;
    @Autowired
    private EmployeeNotification employeeNotification;
    @Autowired
    private EmployeeBanService employeeBanService;

    @Transactional(readOnly = true)
    public BookRentDtoViewer getBookRentDto(Integer id) {
        return bookRentMapper.toDtoViewer(getBookRentById(id));
    }

    @Transactional(readOnly = true)
    public List<BookRentDtoViewer> getBookRentDtos() {
        return bookRentMapper.toListDtoViewers(bookRentRepository.findAll());
    }

    @Transactional
    public BookRentDtoViewer addBookRentDto(BookRentDto bookRentDto) {
        if (employeeService.getEmployeeById(bookRentDto.getIdEmployee()).isBanned()) {
            throw new LimitedAccessException("A book rent cannot be created because this employee is banned",
                    bookRentDto.getIdEmployee());
        }
        if (copyService.countCopiesByIdBook(bookRentDto.getIdBook()) == 0) {
            throw new NoDataFoundException("No copies could be found for this book", bookRentDto.getIdBook());
        }
        Copy copy = copyService.getCopyByBookIdAndStatusAndFlag(bookRentDto.getIdBook(), StatusCopy.AVAILABLE, true);
        bookRentDto.setIdCopy(copy.getCode());

        BookRent bookRent = bookRentMapper.toEntity(bookRentDto, bookService, employeeService, copyService);
        bookRent = preConfigBookRent(bookRent);
        bookRent.getCopy().setStatus(StatusCopy.RENTED);
        return bookRentMapper.toDtoViewer(bookRentRepository.save(bookRent));
    }

    @Transactional
    public BookRentDtoViewer editBookRentDto(BookRentDto bookRentDto) {
        BookRent bookRentToEdit = getBookRentById(bookRentDto.getId());
        return bookRentMapper.toDtoViewer(
                bookRentMapper.updateEntity(bookRentToEdit, bookRentDto, bookService, employeeService, copyService)
        );
    }

    @Transactional
    public BookRentDtoViewer deleteBookRentDto(Integer id) {
        BookRent bookRent = getBookRentById(id);
        if (!bookRent.getStatus().equals(StatusBookRent.RETURNED)) {
            bookRent.getCopy().setStatus(StatusCopy.AVAILABLE);
        }
        bookRentRepository.delete(bookRent);
        return bookRentMapper.toDtoViewer(bookRent);
    }

    @Transactional
    public BookRentDtoViewer giveBackBookRentById(Integer id, Integer idEmployee, int ratingBook) {
        BookRent returnBook = getBookRentById(id);
        if (!returnBook.getEmployee().getId().equals(idEmployee)) {
            throw new EntityMustNotBeModifiedException("This book rent does not belong to the employee", id);
        }
        if(returnBook.getStatus().equals(StatusBookRent.RETURNED)){
            throw new EntityMustNotBeModifiedException("This book has already been returned", id);
        }
        if (returnBook.getStatus().equals(StatusBookRent.LATE)) {
            returnBook.getEmployee().setBanned(true);
            LocalDateTime endDateBanned = calcEndDateOfBan(returnBook.getReturnDate());
            employeeBanService.getEmployeeBanById(returnBook.getEmployee().getId())
                    .ifPresent(employeeBan -> employeeBan.setStopDate(endDateBanned));
        }
        returnBook.setReturnDate(LocalDateTime.now());
        returnBook.setBookRating(ratingBook);
        returnBook.setStatus(StatusBookRent.RETURNED);
        rentRequestService.getNextRentRequest(returnBook.getBook().getId(), returnBook.getCopy())
                .ifPresent(request -> {
                    employeeNotification.notifyForCopyAvailable(request);
                    request.setRequestDate(LocalDateTime.now());
                });
        return bookRentMapper.toDtoViewer(returnBook);
    }

    @Transactional(readOnly = true)
    public List<BookRentDtoViewer> getBookRentsByStatus(StatusBookRent statusBookRent) {
        return bookRentMapper.toListDtoViewers(bookRentRepository.findAllByStatus(statusBookRent));
    }

    @Transactional
    public List<BookRentDtoViewer> getBookRentsByBookId(Integer bookId, StatusBookRent statusBookRent) {
        return bookRentMapper.toListDtoViewers(bookRentRepository.findAllByBookIdAndStatus(bookId, statusBookRent));
    }

    @Transactional
    public BookRentDtoViewer extensionOfRentalDateById(Integer id) {
        BookRent bookRent = getBookRentById(id);
        if(bookRent.getStatus().equals(StatusBookRent.RETURNED)){
            throw new EntityMustNotBeModifiedException("This book has already been returned", id);
        }
        LocalDateTime maxPeriod = bookRent.getRentalDate().plusMonths(Constants.MAX_PERIOD_RENT_MONTHS);
        LocalDateTime extensionPeriod = bookRent.getReturnDate().plusDays(Constants.RENTAL_EXTENSION_DAYS);
        if (extensionPeriod.isAfter(maxPeriod)) {
            throw new ExtensionPeriodLimitExceededException(id);
        }
        bookRent.setReturnDate(extensionPeriod);
        return bookRentMapper.toDtoViewer(bookRent);
    }

    @Transactional
    protected BookRent createBookRentFromRentRequest(Integer bookId, Integer employeeId) {
        Copy copy = copyService.getCopyByBookIdAndStatusAndFlag(bookId, StatusCopy.PENDING, true);
        copy.setStatus(StatusCopy.RENTED);

        BookRent bookRent = new BookRent();
        bookRent = preConfigBookRent(bookRent);
        bookRent.setBook(bookService.getBookById(bookId));
        bookRent.setCopy(copy);
        bookRent.setEmployee(employeeService.getEmployeeById(employeeId));
        return bookRent;
    }

    @Transactional(readOnly = true)
    public List<BookRentDtoViewer> getAllBookRentsByEmployeeId(Integer id) {
        return bookRentMapper.toListDtoViewers(bookRentRepository.findAllByEmployeeId(id));
    }

    @Transactional(readOnly = true)
    public List<BookRent> getBookRentsByStatusAndReturnDateLessThanEqual(StatusBookRent statusBookRent,
                                                                         LocalDateTime returnDate) {
        return bookRentRepository.getAllByStatusAndReturnDateLessThanEqual(statusBookRent, returnDate);
    }

    protected BookRent getBookRentById(Integer id) {
        return bookRentRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("Could not find bookRent with id {}", id);
                    return new NoDataFoundException("This book rent could not be found", id);
                });
    }

    private LocalDateTime calcEndDateOfBan(LocalDateTime date) {
        long diffBetween = ChronoUnit.DAYS.between(date, LocalDateTime.now());
        if (diffBetween < Constants.MIN_BAN_DAYS / 2) {
            return LocalDateTime.now().plusDays(Constants.MIN_BAN_DAYS);
        }
        return LocalDateTime.now().plusDays(diffBetween * 2);
    }

    private BookRent preConfigBookRent(BookRent bookRent) {
        if (bookRent == null) {
            return null;
        }
        bookRent.setRentalDate(LocalDateTime.now());
        bookRent.setReturnDate(LocalDateTime.now().plusMonths(Constants.DEFAULT_PERIOD_RENT_MONTHS));
        bookRent.setBookRating(0);
        bookRent.setStatus(StatusBookRent.ON_GOING);
        return bookRent;
    }
}
