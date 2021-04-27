package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.Book;
import com.arobs.internship.library.entity.Copy;
import com.arobs.internship.library.entity.dto.CopyDto;
import com.arobs.internship.library.entity.dto.viewer.CopyDtoViewer;
import com.arobs.internship.library.entity.types.StatusCopy;
import com.arobs.internship.library.exceptions.EntityMustNotBeModifiedException;
import com.arobs.internship.library.exceptions.NoCopyAvailableForRentException;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.mapper.hibernate.CopyMapper;
import com.arobs.internship.library.repository.CopyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CopyService {
    private static final Logger log = LoggerFactory.getLogger(CopyService.class);

    @Autowired
    private CopyRepository copyRepository;
    @Autowired
    private CopyMapper copyMapper;
    @Autowired
    private BookService bookService;

    @Transactional(readOnly = true)
    public CopyDtoViewer getCopy(UUID id) {
        return copyMapper.toDto(getCopyById(id));
    }

    @Transactional(readOnly = true)
    public List<CopyDtoViewer> getCopies() {
        return copyMapper.toListDtos(copyRepository.findAll());
    }

    @Transactional
    public CopyDtoViewer addCopyDto(CopyDto copyDto) {
        return copyMapper.toDto(copyRepository.save(copyMapper.viewerToEntity(copyDto, bookService)));
    }

    @Transactional
    public CopyDtoViewer editCopyDto(CopyDto copyDto) {
        Copy copyToEdit = getCopyById(copyDto.getCode());
        return copyMapper.toDto(copyMapper.updateCopy(copyToEdit, copyDto, bookService));
    }

    @Transactional
    public CopyDtoViewer deleteCopy(UUID id) {
        Copy copy = getCopyById(id);
        if (copy.getStatus().equals(StatusCopy.PENDING)) {
            throw new EntityMustNotBeModifiedException("This copy cannot be deleted because it is reserved by a rent reqeust", 0);
        }
        copyRepository.delete(copy);
        return copyMapper.toDto(copy);
    }

    @Transactional
    public CopyDtoViewer editStatusCopy(UUID id, StatusCopy statusCopy) {
        Copy copy = getCopyById(id);
        copy.setStatus(statusCopy);
        return copyMapper.toDto(copy);
    }

    @Transactional
    public CopyDtoViewer editFlagCopy(UUID id, boolean flag) {
        Copy copy = getCopyById(id);
        copy.setFlag(flag);
        return copyMapper.toDto(copy);
    }

    @Transactional(readOnly = true)
    public List<CopyDtoViewer> getAllCopiesDtoByBookIdAndStatus(Integer bookId, StatusCopy statusCopy) {
        return copyMapper.toListDtos(getAllCopiesByBookIdAndStatus(bookId, statusCopy, true));
    }

    @Transactional(readOnly = true)
    public List<CopyDtoViewer> getAllCopiesByBookId(Integer bookId) {
        return copyMapper.toListDtos(copyRepository.findAllByBookId(bookId));
    }

    @Transactional
    public List<CopyDtoViewer> addCopyDtoToBook(Integer bookId, Integer numberOfCopies) {
        Book book = bookService.getBookById(bookId);
        List<Copy> copies = new ArrayList<>();
        for (int i = 0; i < numberOfCopies; i++) {
            Copy copyDto = new Copy();
            copyDto.setBook(book);
            copyDto.setStatus(StatusCopy.AVAILABLE);
            copyDto.setFlag(true);
            copies.add(copyDto);
        }
        return copyMapper.toListDtos(copyRepository.saveAll(copies));
    }

    public Copy getCopyById(UUID id) {
        return (copyRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("Could not find copy with id {}", id);
                    return new NoDataFoundException("This copy could not be found", 0);
                }));
    }

    public Copy getCopyByBookIdAndStatus(Integer bookId, StatusCopy statusCopy) {
        return getAllCopiesByBookIdAndStatus(bookId, statusCopy, true)
                .stream()
                .findAny()
                .orElseThrow(() -> new NoDataFoundException("This copy with the status " + statusCopy.getStatus() +
                        " could" +
                        " not" +
                        " be found", bookId));
    }

    protected List<Copy> getAllCopiesByBookIdAndStatus(Integer bookId, StatusCopy statusCopy, boolean flag) {
        return copyRepository.findAllByBookIdAndStatusAndFlag(bookId, statusCopy, flag);
    }

    protected Copy getCopyByBookIdAndStatusAndFlag(Integer bookId, StatusCopy statusCopy, boolean flag) {
        return getAllCopiesByBookIdAndStatus(bookId, statusCopy, flag)
                .stream()
                .filter(copy -> copy.getStatus().equals(statusCopy))
                .findAny()
                .orElseThrow(() -> new NoCopyAvailableForRentException("There are currently no copies available for " +
                        "this. Please add a new Rent Request", bookId));
    }


    protected int countCopiesByIdBook(Integer idBook) {
        return copyRepository.countByBookId(idBook);
    }


}
