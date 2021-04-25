package com.arobs.internship.library.repository;

import com.arobs.internship.library.entity.RentRequest;
import com.arobs.internship.library.entity.helper.StatusRentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RentRequestRepository extends JpaRepository<RentRequest, Integer> {
    List<RentRequest> findByBookIdOrderByRequestDateAsc(Integer bookId);

    List<RentRequest> findByBookIdAndStatusOrderByRequestDateAsc(Integer idBook, StatusRentRequest statusRentRequest);

    List<RentRequest> findAllByEmployeeId(Integer id);

    List<RentRequest> findAllByStatusAndRequestDateLessThanEqual(StatusRentRequest statusRentRequest, LocalDateTime date);
}
