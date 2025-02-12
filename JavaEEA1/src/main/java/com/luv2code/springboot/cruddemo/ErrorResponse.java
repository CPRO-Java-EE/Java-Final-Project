package com.luv2code.springboot.cruddemo;

import lombok.Getter;
import lombok.Setter;

// ErrorResponse class to represent a custom error message
@Getter
@Setter
public class ErrorResponse {
    // Fields to store error details
    private String message;
    private int status;
    private long timestamp;

    // Constructor to initialize the fields with provided values
    public ErrorResponse(String message, int status, long timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }
}
