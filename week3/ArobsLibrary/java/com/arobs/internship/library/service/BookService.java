package com.arobs.internship.library.service;

import com.arobs.internship.library.exceptions.BadRequestException;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.model.Book;
import com.arobs.internship.library.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements GenericService<Book> {
    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getById(int id) {
        Book book = bookRepository.getById(id);
        if (book != null) {
            return book;
        }
        throw new NoDataFoundException("The book is not found", id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Book save(Book book) {
        int keyBook = bookRepository.save(book);
        if (keyBook > 0) {
            book.setId(keyBook);
            return book;
        }
        throw new BadRequestException("Bad request", book.getId());
    }

    @Override
    public Book update(int id, Book book) {
        if (bookRepository.update(id, book) > 0) {
            return book;
        }
        throw new BadRequestException("Bad request", id);
    }

    @Override
    public int delete(int id) {
        return bookRepository.deleteById(id);
    }
}
