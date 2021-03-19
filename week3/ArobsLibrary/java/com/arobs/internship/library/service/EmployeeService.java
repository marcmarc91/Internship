package com.arobs.internship.library.service;

import com.arobs.internship.library.exceptions.BadRequestException;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.model.EmployeeEntity;
import com.arobs.internship.library.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements GenericService<EmployeeEntity> {
    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity getById(int id) {
        EmployeeEntity employee = employeeRepository.getById(id);
        if (employee != null) {
            return employee;
        }
        throw new NoDataFoundException("The employee is not found", id);
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return employeeRepository.getAll();
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        int keyEmployee = employeeRepository.save(employeeEntity);
        if (keyEmployee > 0) {
            employeeEntity.setId(keyEmployee);
            return employeeEntity;
        }
        throw new BadRequestException("Bad request", employeeEntity.getId());
    }

    @Override
    public EmployeeEntity update(int id, EmployeeEntity employeeEntity) {
        if (employeeRepository.update(id, employeeEntity) > 0) {
            return employeeEntity;
        }
        throw new BadRequestException("Bad request", id);
    }

    @Override
    public int delete(int id) {
        return employeeRepository.deleteById(id);
    }

}
