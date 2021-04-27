package com.arobs.internship.library.entity.dto;

import com.arobs.internship.library.entity.types.StatusRentRequest;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RentRequestDto {
    private Integer id;
    @NotNull
    private Integer idEmployee;
    @NotNull
    private Integer idBook;
//    @FutureOrPresent
    private LocalDateTime requestDate;
    private StatusRentRequest status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public StatusRentRequest getStatus() {
        return status;
    }

    public void setStatus(StatusRentRequest status) {
        this.status = status;
    }
}
