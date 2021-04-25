package com.arobs.internship.library.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_ban")
public class EmployeeBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "stop_date")
    private LocalDateTime stopDate;
    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false)
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
