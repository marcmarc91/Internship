package com.arobs.internship.library.controller;

import com.arobs.internship.library.entity.dto.viewer.BookDtoViewer;
import com.arobs.internship.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("statistics")
public class StatisticController {
    @Autowired
    BookService bookService;


    @GetMapping("/topBooksRented/{start}/{end}/{topX}")
    public ResponseEntity<List<BookDtoViewer>> getTop(@PathVariable("start") @DateTimeFormat(iso =
            DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                      @PathVariable("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
                                                      @PathVariable("topX") Integer size) {
        List<BookDtoViewer> rentDtoViewerList;
        rentDtoViewerList = bookService.getTopXBooksRentedInSpecifiedPeriod(startDate, endDate, Objects.requireNonNullElse(size, Integer.MAX_VALUE));
        return new ResponseEntity<>(rentDtoViewerList, HttpStatus.OK);
    }
//
//    @GetMapping("/top")
//    public List<BookDtoViewer> getTop() {
//        return statisticService.getTop();
//    }
//
//    @GetMapping
//    public ResponseEntity<List<BookDtoViewer>> getAllBooks() {
//        return new ResponseEntity<>(statisticService.getBookDtos(), HttpStatus.OK);
//    }
}
