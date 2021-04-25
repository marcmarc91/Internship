package com.arobs.internship.library.controller;

import com.arobs.internship.library.entity.dto.BookDto;
import com.arobs.internship.library.entity.dto.viewer.BookDtoViewer;
import com.arobs.internship.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookDtoViewer> getBookById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.getBookDto(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookDtoViewer>> getAllBooks() {
        return new ResponseEntity<>(bookService.getBookDtos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDtoViewer> addBook(@Valid @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.addBookDto(bookDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BookDtoViewer> updateBook(@Valid @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.editBookDto(bookDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDtoViewer> deleteBook(@PathVariable Integer id) {
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }

    @PostMapping("{bookId}/tag/{tagId}/")
    public ResponseEntity<BookDtoViewer> addTagToBook(@PathVariable Integer bookId,
                                                      @PathVariable Integer tagId) {
        return new ResponseEntity<>(bookService.addTagToBook(tagId, bookId), HttpStatus.CREATED);
    }

    @DeleteMapping("{bookId}/tag/{tagId}/")
    public ResponseEntity<BookDtoViewer> removeTagFromBook(@PathVariable Integer bookId,
                                                           @PathVariable Integer tagId) {
        return new ResponseEntity<>(bookService.removeTagFromBook(tagId, bookId), HttpStatus.OK);
    }

    @GetMapping("/tags/{tagId}")
    public ResponseEntity<List<BookDtoViewer>> getBooksByTagIds(@PathVariable Set<Integer> tagId) {
        return new ResponseEntity<>(bookService.getBooksByTagId(tagId), HttpStatus.OK);
    }

    @PostMapping("{bookId}/author/{authorId}/")
    public ResponseEntity<BookDtoViewer> addAuthorToBook(@PathVariable Integer bookId,
                                                         @PathVariable Integer authorId) {
        return new ResponseEntity<>(bookService.addAuthorToBook(authorId, bookId), HttpStatus.CREATED);
    }

    @DeleteMapping("{bookId}/author/{tagId}/")
    public ResponseEntity<BookDtoViewer> removeAuthorFromBook(@PathVariable Integer bookId,
                                                              @PathVariable Integer authorId) {
        return new ResponseEntity<>(bookService.removeAuthorFromBook(authorId, bookId), HttpStatus.OK);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<BookDtoViewer>> getBooksByAuthorId(@PathVariable Integer authorId) {
        return new ResponseEntity<>(bookService.getBooksByAuthorId(authorId), HttpStatus.OK);
    }
}
