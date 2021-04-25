package com.arobs.internship.library.repository;

import com.arobs.internship.library.entity.BookRent;
import com.arobs.internship.library.entity.helper.StatusBookRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookRentRepository extends JpaRepository<BookRent, Integer> {
    List<BookRent> findAllByStatus(StatusBookRent statusBookRent);

    List<BookRent> findAllByBookIdAndStatus(Integer bookId, StatusBookRent statusBookRent);

    List<BookRent> findAllByEmployeeId(Integer id);

    List<BookRent> getAllByStatusAndReturnDateLessThanEqual(StatusBookRent statusBookRent, LocalDateTime returnDate);
}
