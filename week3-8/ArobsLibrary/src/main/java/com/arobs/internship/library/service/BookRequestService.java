package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.Author;
import com.arobs.internship.library.entity.BookRequest;
import com.arobs.internship.library.entity.dto.BookDto;
import com.arobs.internship.library.entity.dto.BookRequestDto;
import com.arobs.internship.library.entity.dto.CopyDto;
import com.arobs.internship.library.entity.dto.viewer.BookDtoViewer;
import com.arobs.internship.library.entity.dto.viewer.BookRequestDtoViewer;
import com.arobs.internship.library.entity.types.StatusBookRequest;
import com.arobs.internship.library.entity.types.StatusCopy;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.mapper.hibernate.BookRequestMapper;
import com.arobs.internship.library.repository.BookRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookRequestService {
    private static final Logger log = LoggerFactory.getLogger(BookRequestService.class);

    @Autowired
    private BookRequestRepository bookRequestRepository;
    @Autowired
    private BookRequestMapper bookRequestMapper;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CopyService copyService;

    @Transactional(readOnly = true)
    public BookRequestDtoViewer getBookRequestDto(Integer id) {
        return bookRequestMapper.toDtoViewer(getBookRequestById(id));
    }

    @Transactional(readOnly = true)
    public List<BookRequestDtoViewer> getAllBookRequestDtos() {
        return bookRequestMapper.toListDtoViewers(bookRequestRepository.findAll());
    }

    @Transactional
    public BookRequestDtoViewer addBookRequestDto(BookRequestDto bookRequestDto) {
        bookRequestDto.setStatus(StatusBookRequest.PENDING);
        bookRequestDto.setDate(LocalDateTime.now());
        return bookRequestMapper.toDtoViewer(bookRequestRepository.save(bookRequestMapper.toEntity(bookRequestDto, authorService)));
    }

    @Transactional
    public BookRequestDtoViewer editBookRequestDto(BookRequestDto bookRequestDto) {
        BookRequest bookRequestToEdit = getBookRequestById(bookRequestDto.getId());
        return bookRequestMapper.toDtoViewer(bookRequestMapper.updateEntity(bookRequestToEdit, bookRequestDto, authorService));
    }

    @Transactional
    public BookRequestDtoViewer deleteBookRequestDto(Integer id) {
        BookRequest bookRequest = getBookRequestById(id);
        bookRequestRepository.delete(bookRequest);
        return bookRequestMapper.toDtoViewer(bookRequest);
    }

    @Transactional
    public BookRequestDtoViewer acceptBookRequestDto(Integer id, BookDto bookDto) {
        BookRequest bookRequest = getBookRequestById(id);
        if (!bookRequest.getStatus().equals(StatusBookRequest.PENDING)) {
            throw new NoDataFoundException("This book request is not awaiting confirmation", id);
        }
        bookRequest.setStatus(StatusBookRequest.ACCEPTED);
        bookDto.setTitle(bookRequest.getTitle());
        bookDto.setAuthors(bookRequest.getAuthors()
                .stream()
                .map(Author::getId)
                .collect(Collectors.toSet()));
        BookDtoViewer addBookDto = bookService.addBookDto(bookDto);
        for (int i = 0; i < bookRequest.getNoCopies(); i++) {
            CopyDto copyDto = new CopyDto();
            copyDto.setFlag(true);
            copyDto.setStatus(StatusCopy.AVAILABLE);
            copyDto.setIdBook(addBookDto.getId());
            copyService.addCopyDto(copyDto);
        }
        return bookRequestMapper.toDtoViewer(bookRequest);
    }

    @Transactional
    public BookRequestDtoViewer declineBookRequestDto(Integer id) {
        BookRequest bookRequest = getBookRequestById(id);
        if (!bookRequest.getStatus().equals(StatusBookRequest.PENDING)) {
            throw new NoDataFoundException("This book request is not awaiting confirmation", id);
        }
        bookRequest.setStatus(StatusBookRequest.REJECTED);
        return bookRequestMapper.toDtoViewer(bookRequest);
    }

    protected BookRequest getBookRequestById(Integer id) {
        return bookRequestRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("Could not find author with id {}", id);
                    return new NoDataFoundException("This author could not be found", id);
                });
    }


}
