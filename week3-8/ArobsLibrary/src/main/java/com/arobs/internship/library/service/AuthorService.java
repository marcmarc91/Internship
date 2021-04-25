package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.Author;
import com.arobs.internship.library.entity.dto.AuthorDto;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.mapper.hibernate.AuthorMapper;
import com.arobs.internship.library.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class AuthorService {
    private static final Logger log = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorMapper authorMapper;

    @Transactional(readOnly = true)
    public AuthorDto getAuthorDto(Integer id) {
        return authorMapper.toDto(getAuthorById(id));
    }

    @Transactional(readOnly = true)
    public List<AuthorDto> getAuthorDtos() {
        return authorMapper.toListDtos(authorRepository.findAll());
    }

    @Transactional
    public AuthorDto addAuthorDto(AuthorDto authorDto) {
        return authorMapper.toDto(authorRepository.save(authorMapper.toEntity(authorDto)));
    }

    @Transactional
    public AuthorDto editAuthorDto(AuthorDto authorDto) {
        Author authorToEdit = getAuthorById(authorDto.getId());
        return authorMapper.toDto(authorMapper.updateEntity(authorToEdit, authorDto));
    }

    @Transactional
    public AuthorDto deleteAuthorDto(Integer id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
        return authorMapper.toDto(author);
    }

    @Transactional(readOnly = true)
    public List<Author> getAuthorsByIds(Set<Integer> ids) {
        return authorRepository.findAllByIdIn(ids);
    }

    public Author getAuthorById(Integer id) {
        return (authorRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("Could not find author with id {}", id);
                    return new NoDataFoundException("This author could not be found", id);
                }));
    }

}
