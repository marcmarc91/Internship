package com.arobs.internship.library.controller;

import com.arobs.internship.library.entity.dto.EmployeeDto;
import com.arobs.internship.library.entity.helper.RoleType;
import com.arobs.internship.library.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeDto(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getEmployeeDtos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        EmployeeDto employee = employeeService.addEmployeeDto(employeeDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(uri).body(employee);
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.editEmployeeDto(employeeDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.deleteEmployeeDto(id), HttpStatus.OK);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByRole(@PathVariable("role") RoleType roleType) {
        return new ResponseEntity<>(employeeService.getEmployeeDtosByRole(roleType), HttpStatus.OK);

    }
}
