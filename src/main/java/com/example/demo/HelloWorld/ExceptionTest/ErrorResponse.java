package com.example.demo.HelloWorld.ExceptionTest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author maxiao
 */
@Data
public class ErrorResponse {

    private String errorCode;

    private String errorType;

    private String errorMessage;

    public ErrorResponse(Exception e) {
        this("",e.getClass().getName(), e.getMessage());
    }

    public ErrorResponse(String errorCode, String errorType, String errorMessage) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }
}
