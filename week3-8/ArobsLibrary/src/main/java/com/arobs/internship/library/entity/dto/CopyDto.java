package com.arobs.internship.library.entity.dto;

import com.arobs.internship.library.entity.helper.StatusCopy;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CopyDto {
    private UUID code;
    private boolean flag;
    @NotNull
    private StatusCopy status;
    @NotNull
    private Integer idBook;

    public UUID getCode() {
        return code;
    }

    public void setCode(UUID code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public StatusCopy getStatus() {
        return status;
    }

    public void setStatus(StatusCopy status) {
        this.status = status;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }
}
