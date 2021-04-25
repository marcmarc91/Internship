package com.arobs.internship.library.controller;

import com.arobs.internship.library.entity.dto.AuthorDto;
import com.arobs.internship.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(authorService.getAuthorDto(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAuthorDtos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> addAuthor(@Valid @RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.addAuthorDto(authorDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AuthorDto> updateAuthor(@Valid @RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.editAuthorDto(authorDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorDto> deleteAuthor(@PathVariable Integer id) {
        return new ResponseEntity<>(authorService.deleteAuthorDto(id), HttpStatus.OK);
    }
}
