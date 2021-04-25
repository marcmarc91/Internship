package com.arobs.internship.library.entity.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class EmployeeBanDto {
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime stopDate;
    @NotNull
    private Integer idEmployee;

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

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }
}
