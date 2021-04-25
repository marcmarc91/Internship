package com.arobs.internship.library.controller;

import com.arobs.internship.library.entity.dto.BookRentDto;
import com.arobs.internship.library.entity.dto.viewer.BookRentDtoViewer;
import com.arobs.internship.library.entity.helper.StatusBookRent;
import com.arobs.internship.library.service.BookRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("bookRents")
@Validated
public class BookRentController {

    @Autowired
    BookRentService bookRentService;

    @GetMapping("/{id}")
    public ResponseEntity<BookRentDtoViewer> getBookRentById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookRentService.getBookRentDto(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookRentDtoViewer>> getAllBookRents() {
        return new ResponseEntity<>(bookRentService.getBookRentDtos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookRentDtoViewer> addBookRent(@Valid @RequestBody BookRentDto bookRentDto) {
        return new ResponseEntity<>(bookRentService.addBookRentDto(bookRentDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BookRentDtoViewer> updateBookRent(@Valid @RequestBody BookRentDto bookRentDto) {
        return new ResponseEntity<>(bookRentService.editBookRentDto(bookRentDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookRentDtoViewer> deleteBookRent(@PathVariable Integer id) {
        return new ResponseEntity<>(bookRentService.deleteBookRentDto(id), HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<BookRentDtoViewer>> getAllBookRentsByStatus(@PathVariable("status") StatusBookRent statusBookRent) {
        return new ResponseEntity<>(bookRentService.getBookRentsByStatus(statusBookRent), HttpStatus.OK);
    }

    @PostMapping("/{id}/employee/{idEmployee}rating/{ratingBook}")
    public ResponseEntity<BookRentDtoViewer> giveBackBookRentByIdAndIdEmployee(@PathVariable Integer id,
                                                                               @PathVariable Integer idEmployee,
                                                                               @PathVariable @Min(1) @Max(5) int ratingBook) {
        return new ResponseEntity<>(bookRentService.giveBackBookRentById(id, idEmployee, ratingBook),
                HttpStatus.CREATED);
    }

    @GetMapping("/book/{bookId}/status/{status}")
    public ResponseEntity<List<BookRentDtoViewer>> getAllBookRentsByBookIdAndStatus(@PathVariable Integer bookId,
                                                                                    @PathVariable("status") StatusBookRent statusBookRent) {
        return new ResponseEntity<>(bookRentService.getBookRentsByBookId(bookId, statusBookRent), HttpStatus.OK);
    }

    @GetMapping("/employee/{idEmployee}")
    public ResponseEntity<List<BookRentDtoViewer>> getAllBookRentsByEmployeeId(@PathVariable("idEmployee") Integer id) {
        return new ResponseEntity<>(bookRentService.getAllBookRentsByEmployeeId(id), HttpStatus.OK);
    }

    @PostMapping("/extension/{id}")
    public ResponseEntity<BookRentDtoViewer> extensionOfRentalById(@PathVariable Integer id) {
        return new ResponseEntity<>(bookRentService.extensionOfRentalDateById(id), HttpStatus.CREATED);
    }

}