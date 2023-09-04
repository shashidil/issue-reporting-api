package com.issuereporting.issuereportingapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IssueNotFoundException extends  RuntimeException{
    private static final long serialVersionUID = 1L;
    public IssueNotFoundException(String message) {
        super(message);
    }
}
