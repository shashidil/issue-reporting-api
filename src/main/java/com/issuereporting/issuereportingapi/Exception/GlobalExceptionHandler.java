package com.issuereporting.issuereportingapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> Exception(Exception exception, WebRequest request){
        Error error = new Error(new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(IssueNotFoundException.class)
    public ResponseEntity<?> IssueNotFoundException(Exception exception, WebRequest request){
        Error error = new Error(new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
