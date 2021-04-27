package com.arobs.internship.library.entity.dto.viewer;

import com.arobs.internship.library.entity.types.StatusCopy;

import java.util.UUID;

public class CopyDtoViewer {
    private UUID code;
    private boolean flag;
    private StatusCopy status;
    private BookDtoViewer book;

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

    public BookDtoViewer getBook() {
        return book;
    }

    public void setBook(BookDtoViewer book) {
        this.book = book;
    }
}
