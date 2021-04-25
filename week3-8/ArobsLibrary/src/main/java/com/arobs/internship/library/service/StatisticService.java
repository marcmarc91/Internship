package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.dto.viewer.BookDtoViewer;
import com.arobs.internship.library.mapper.hibernate.BookMapper;
import com.arobs.internship.library.mapper.hibernate.BookRentMapper;
import com.arobs.internship.library.repository.BookRentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StatisticService {
    private static final Logger log = LoggerFactory.getLogger(StatisticService.class);

    @Autowired
    BookRentRepository bookRentRepository;
    @Autowired
    BookRentMapper bookRentMapper;
    @Autowired
    BookService bookService;
    @Autowired
    BookMapper bookMapper;
//
//    public List<BookDtoViewer> getTop() {
//        return (bookService.getBooksByOrderByBookRents());
//    }

    @Transactional(readOnly = true)
    public List<BookDtoViewer> getBookDtos() {
        return (bookService.getBookDtos());
    }
}
