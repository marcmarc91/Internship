package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.dto.BookDto;
import com.arobs.internship.library.entity.dto.viewer.BookDtoViewer;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootTest
public class BookServiceTest {
    private static final Logger log = LoggerFactory.getLogger(BookServiceTest.class);

    @Autowired
    BookService bookService;
    int idNewBook;


    @Test
    @DisplayName("Add New Book")
    @Order(1)
    int addNewBook() {
        BookDto bookDto = new BookDto();
//        bookDto.setDateAdded(LocalDate.now());
        bookDto.setDescription("Description Book Test");
        bookDto.setTitle("New Book Test");
        bookDto.setAuthors(new HashSet<>(Arrays.asList(1, 2)));
        bookDto.setTags(new HashSet<>(Arrays.asList(1, 2)));

        BookDtoViewer bookDtoViewer = bookService.addBookDto(bookDto);
        Assertions.assertEquals(bookDto.getTitle(), bookDtoViewer.getTitle());
        idNewBook = bookDtoViewer.getId();
        System.out.println("ID " + idNewBook);
        return idNewBook;
    }

    @Test
    @DisplayName("Get Book Not Found")
    @Order(3)
        //    @Disabled
    void getBookNotFound() {
        Assertions.assertThrows(NoDataFoundException.class, () -> {
            bookService.getBookById(idNewBook);
        });
    }


    @Test
    @DisplayName("Delete Book")
    @Order(2)
//    @Disabled
    void deleteBook() {
        System.out.println("OD" + idNewBook);
        bookService.deleteBook(addNewBook());
    }


}
