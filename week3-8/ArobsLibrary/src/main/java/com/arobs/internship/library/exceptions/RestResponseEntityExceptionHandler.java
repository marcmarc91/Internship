package com.arobs.internship.library.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = NoDataFoundException.class)
    protected ResponseEntity<Object> handleNoDataFound(NoDataFoundException e, WebRequest request) {
        log.error("Exception ResourceNotFound", e);
        ErrorObj errorObj = getErrorObj(e.getMessage(), e.getId(), HttpStatus.NOT_FOUND);
        return handleExceptionInternal(e, errorObj, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = NoCopyAvailableForRentException.class)
    protected ResponseEntity<Object> handleNoCopyAvailableForRent(NoCopyAvailableForRentException e, WebRequest request) {
        log.error("Exception ResourceNotFound", e);
        ErrorObj errorObj = getErrorObj(e.getMessage(), e.getBookId(), HttpStatus.FORBIDDEN);
        return handleExceptionInternal(e, errorObj, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = ExtensionPeriodLimitExceededException.class)
    protected ResponseEntity<Object> handleExtensionPeriodLimitExceeded(ExtensionPeriodLimitExceededException e, WebRequest request) {
        log.error("Exception ExtensionPeriodLimitExceeded", e);
        ErrorObj errorObj = getErrorObj(e.getMessage(), e.getIdRentBook(), HttpStatus.FORBIDDEN);
        return handleExceptionInternal(e, errorObj, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = EntityMustNotBeModifiedException.class)
    protected ResponseEntity<Object> handleEntityMustNotBeModified(EntityMustNotBeModifiedException e, WebRequest request) {
        log.error("Exception EntityMustNotBeModified", e);
        ErrorObj errorObj = getErrorObj(e.getMessage(), e.getId(), HttpStatus.FORBIDDEN);
        return handleExceptionInternal(e, errorObj, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = LimitedAccessException.class)
    protected ResponseEntity<Object> handleLimitedAccess(LimitedAccessException e, WebRequest request) {
        log.error("Exception LimitedAccess", e);
        ErrorObj errorObj = getErrorObj(e.getMessage(), e.getId(), HttpStatus.FORBIDDEN);
        return handleExceptionInternal(e, errorObj, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintValidation(ConstraintViolationException e, WebRequest request) {
        log.error("Exception ConstraintValidation", e);
        List<String> messages = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            messages.add(violation.getPropertyPath() + ": " + violation.getMessage());
        }
        ErrorObj errorObj = getErrorObj(messages, 0, HttpStatus.BAD_REQUEST);
        return handleExceptionInternal(e, errorObj, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Exception MethodArgumentNotValid", e);
        List<String> messages = new ArrayList<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            messages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }
        for (ObjectError objectError : e.getBindingResult().getGlobalErrors()) {
            messages.add(objectError.getObjectName() + ": " + objectError.getDefaultMessage());
        }
        ErrorObj errorObj = getErrorObj(messages, 0, HttpStatus.BAD_REQUEST);
        return handleExceptionInternal(e, errorObj, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Exception HttpMessageNotReadable", e);
        if (!(e.getMostSpecificCause() instanceof EnumValidationException)) {
            ErrorObj errorObj = getErrorObj(e.getMostSpecificCause().getMessage(), 0, HttpStatus.BAD_REQUEST);
            return handleExceptionInternal(e, errorObj, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        } else {
            EnumValidationException exception = (EnumValidationException) e.getMostSpecificCause();
            ErrorObj errorObj = getErrorObj(
                    exception.getEnumValue() + " is an invalid " + exception.getEnumName() + ". Accepted values: " + Arrays.toString(exception.getEnumValues()),
                    0,
                    HttpStatus.BAD_REQUEST);
            return handleExceptionInternal(exception, errorObj, headers, HttpStatus.BAD_REQUEST, request);
        }
    }

    private ErrorObj getErrorObj(String message, int id, HttpStatus httpStatus) {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessage(message);
        errorObj.setId(id);
        errorObj.setStatus(httpStatus.value());
        errorObj.setError(httpStatus.getReasonPhrase());
        errorObj.setTimestamp(new Date());
        return errorObj;
    }

    private ErrorObj getErrorObj(List<String> messages, int id, HttpStatus httpStatus) {
        ErrorObj errorObj = new ErrorObj();
        errorObj.setMessages(messages);
        errorObj.setId(id);
        errorObj.setStatus(httpStatus.value());
        errorObj.setError(httpStatus.getReasonPhrase());
        errorObj.setTimestamp(new Date());
        return errorObj;
    }
}
