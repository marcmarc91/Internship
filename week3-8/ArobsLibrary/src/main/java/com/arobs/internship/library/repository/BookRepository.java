package com.arobs.internship.library.repository;

import com.arobs.internship.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Set<Book> findAllByTagsIdIn(Set<Integer> tagId);

    List<Book> findAllByAuthorsId(int authorId);

//    Page<Book> findAllByOrderByBookRents(Pageable pageable);
//    Set<Book> findAllByOrderByBookRents();
}
