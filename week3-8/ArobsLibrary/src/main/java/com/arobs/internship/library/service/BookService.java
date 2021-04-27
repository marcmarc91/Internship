package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.Author;
import com.arobs.internship.library.entity.Book;
import com.arobs.internship.library.entity.Tag;
import com.arobs.internship.library.entity.dto.BookDto;
import com.arobs.internship.library.entity.dto.viewer.BookDtoViewer;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.mapper.hibernate.BookMapper;
import com.arobs.internship.library.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BookService {
    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TagService tagService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookMapper bookMapper;


    @Transactional(readOnly = true)
    public BookDtoViewer getBookDto(Integer id) {
        return bookMapper.toDtoViewer(getBookById(id));
    }

    @Transactional(readOnly = true)
    public List<BookDtoViewer> getBookDtos() {
        return bookMapper.toListDtoViewers(bookRepository.findAll());
    }

    @Transactional
    public BookDtoViewer addBookDto(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto, tagService, authorService);
        book.setDateAdded(LocalDate.now());
        return bookMapper.toDtoViewer(bookRepository.save(book));
    }

    @Transactional
    public BookDtoViewer editBookDto(BookDto bookDto) {
        Book bookToEdit = getBookById(bookDto.getId());
        return bookMapper.toDtoViewer(bookMapper.updateEntity(bookToEdit, bookDto, tagService, authorService));
    }

    @Transactional
    public BookDtoViewer deleteBook(Integer id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
        return bookMapper.toDtoViewer(book);
    }

    @Transactional
    public BookDtoViewer addTagToBook(Integer tagId, Integer bookId) {
        Book book = getBookById(bookId);
        Tag tag = tagService.getTagById(tagId);
        book.addTag(tag);
        return bookMapper.toDtoViewer(book);
    }

    @Transactional
    public BookDtoViewer removeTagFromBook(Integer tagId, Integer bookId) {
        Book book = getBookById(bookId);
        Tag tag = tagService.getTagById(tagId);
        book.removeTag(tag);
        return bookMapper.toDtoViewer(book);
    }

    @Transactional(readOnly = true)
    public List<BookDtoViewer> getBooksByTagId(Set<Integer> tagId) {
        Set<Book> allByTagsIdIn = bookRepository.findAllByTagsIdIn(tagId);
        return bookMapper.toListDtoViewers(new ArrayList<>(allByTagsIdIn));
    }

    @Transactional
    public BookDtoViewer addAuthorToBook(Integer authorId, Integer bookId) {
        Book book = getBookById(bookId);
        Author author = authorService.getAuthorById(authorId);
        book.addAuthor(author);
        return bookMapper.toDtoViewer(book);
    }

    @Transactional
    public BookDtoViewer removeAuthorFromBook(Integer authorId, Integer bookId) {
        Book book = getBookById(bookId);
        Author author = authorService.getAuthorById(authorId);
        book.removeAuthor(author);
        return bookMapper.toDtoViewer(book);
    }

    @Transactional(readOnly = true)
    public List<BookDtoViewer> getBooksByAuthorId(Integer authorId) {
        return bookMapper.toListDtoViewers(bookRepository.findAllByAuthorsId(authorId));
    }

    public Book getBookById(Integer bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> {
                    log.info("Could not find book with id {}", bookId);
                    return new NoDataFoundException("This book could not be found", bookId);
                });
    }

}
