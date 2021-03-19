package com.arobs.internship.library.controller;

import com.arobs.internship.library.model.Book;
import com.arobs.internship.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        log.info("Get book by id:{}", id);
        return bookService.getById(id);
    }

    @GetMapping("/")
    public List<Book> getAllBooks() {
        log.info("Get all books");
        return bookService.getAll();
    }

    @PostMapping("/")
    public Book addBook(@RequestBody Book book) {
        log.info("Save book with title {}", book.getTitle());
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        log.info("Update book with id:{}", id);
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public Integer deleteBook(@PathVariable int id) {
        log.info("Delete employee with id:{}", id);
        return bookService.delete(id);
    }

}
