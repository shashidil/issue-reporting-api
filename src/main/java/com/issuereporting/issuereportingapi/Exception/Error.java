package com.issuereporting.issuereportingapi.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Error {
    private Date timeStamp;
    private  String message;
    private String details;
}
