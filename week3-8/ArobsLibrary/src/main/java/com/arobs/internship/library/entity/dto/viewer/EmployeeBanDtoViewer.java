package com.arobs.internship.library.entity.dto.viewer;

import com.arobs.internship.library.entity.Employee;

import java.time.LocalDateTime;

public class EmployeeBanDtoViewer {
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime stopDate;
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStopDate() {
        return stopDate;
    }

    public void setStopDate(LocalDateTime stopDate) {
        this.stopDate = stopDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
