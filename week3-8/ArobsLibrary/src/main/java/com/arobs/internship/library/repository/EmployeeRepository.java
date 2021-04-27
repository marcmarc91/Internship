package com.arobs.internship.library.repository;

import com.arobs.internship.library.entity.Employee;
import com.arobs.internship.library.entity.types.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByRole(RoleType roleType);
}
