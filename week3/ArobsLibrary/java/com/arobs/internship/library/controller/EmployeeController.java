package com.arobs.internship.library.controller;

import com.arobs.internship.library.model.EmployeeEntity;
import com.arobs.internship.library.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable("id") int id) {
        log.info("Get employee by id:{}", id);
        return employeeService.getById(id);
    }

    @GetMapping("/")
    public List<EmployeeEntity> getAllEmployees() {
        log.info("Get all employees");
        return employeeService.getAll();
    }

    @PostMapping("/")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee) {
        log.info("Save employee with name {}", employee.getName());
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@PathVariable int id, @RequestBody EmployeeEntity employee) {
        log.info("Update employee with id:{}", id);
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public Integer deleteEmployee(@PathVariable int id) {
        log.info("Delete employee with id:{}", id);
        return employeeService.delete(id);
    }

}
