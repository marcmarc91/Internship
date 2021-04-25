package com.arobs.internship.library.repository;

import com.arobs.internship.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllByIdIn(Set<Integer> ids);
}
