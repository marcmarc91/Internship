package com.arobs.internship.library.repository;

import com.arobs.internship.library.entity.EmployeeBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeBanRepository extends JpaRepository<EmployeeBan, Integer> {
    List<EmployeeBan> getAllBanByEmployeeIsBannedAndStopDateLessThanEqual(boolean isBanned, LocalDateTime date);
}
