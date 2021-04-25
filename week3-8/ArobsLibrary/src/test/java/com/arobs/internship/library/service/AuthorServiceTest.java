package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.dto.AuthorDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    AuthorService authorService;

    @Test
    @DisplayName("Test name")
    void testName() {
        System.out.println(authorService.getAuthorDtos().size());

    }

    @Test
    @DisplayName("AddAuthorTest")
    void addAuthorTest(@Autowired AuthorService authorService) {
        AuthorDto author = new AuthorDto();
        author.setName("AuthorTest");
        AuthorDto authorCreated = authorService.addAuthorDto(author);
        Assertions.assertEquals(author.getName(), authorCreated.getName());
    }


}                                       
