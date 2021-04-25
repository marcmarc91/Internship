package com.arobs.internship.library.controller;

import com.arobs.internship.library.entity.dto.BookDto;
import com.arobs.internship.library.entity.dto.BookRequestDto;
import com.arobs.internship.library.entity.dto.viewer.BookRequestDtoViewer;
import com.arobs.internship.library.service.BookRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("bookRequests")
public class BookRequestController {

    @Autowired
    BookRequestService bookRequestService;

    @GetMapping("/{id}")
    public ResponseEntity<BookRequestDtoViewer> getBookRequestById(@PathVariable Integer id) {
        return new ResponseEntity<>(bookRequestService.getBookRequestDto(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookRequestDtoViewer>> getAllBookRequests() {
        return new ResponseEntity<>(bookRequestService.getAllBookRequestDtos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookRequestDtoViewer> addBookRequest(@Valid @RequestBody BookRequestDto bookRequestDto) {
        return new ResponseEntity<>(bookRequestService.addBookRequestDto(bookRequestDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BookRequestDtoViewer> updateBookRequest(@Valid @RequestBody BookRequestDto bookRequestDto) {
        return new ResponseEntity<>(bookRequestService.editBookRequestDto(bookRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookRequestDtoViewer> deleteBookRequest(@PathVariable Integer id) {
        return new ResponseEntity<>(bookRequestService.deleteBookRequestDto(id), HttpStatus.OK);
    }

    @PostMapping("/accept/{id}")
    public ResponseEntity<BookRequestDtoViewer> acceptBookRequest(@PathVariable Integer id,
                                                                  @Valid @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookRequestService.acceptBookRequestDto(id, bookDto), HttpStatus.CREATED);
    }

    @PostMapping("/decline/{id}")
    public ResponseEntity<BookRequestDtoViewer> declineBookRequest(@PathVariable Integer id) {
        return new ResponseEntity<>(bookRequestService.declineBookRequestDto(id), HttpStatus.CREATED);
    }
}
