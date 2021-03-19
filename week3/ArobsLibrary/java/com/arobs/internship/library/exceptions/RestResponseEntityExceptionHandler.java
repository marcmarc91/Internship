package com.arobs.internship.library.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = NoDataFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(NoDataFoundException exception, WebRequest request) {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(exception.getMessage());
        errorObj.setId(exception.getId());
        errorObj.setStatus(HttpStatus.NOT_FOUND.value());
        errorObj.setTimestamp(System.currentTimeMillis());
        return handleExceptionInternal(exception, errorObj, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = BadRequestException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(BadRequestException exception, WebRequest request) {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(exception.getMessage());
        errorObj.setId(exception.getId());
        errorObj.setStatus(HttpStatus.BAD_REQUEST.value());
        errorObj.setTimestamp(System.currentTimeMillis());
        return handleExceptionInternal(exception, errorObj, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
