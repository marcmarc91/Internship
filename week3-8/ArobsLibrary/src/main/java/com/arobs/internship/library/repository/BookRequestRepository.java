package com.arobs.internship.library.repository;

import com.arobs.internship.library.entity.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest, Integer> {
}
