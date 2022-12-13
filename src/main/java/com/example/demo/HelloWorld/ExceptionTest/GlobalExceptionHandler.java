package com.example.demo.HelloWorld.ExceptionTest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author maxiao
 */
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    ErrorResponse npeResponse = new ErrorResponse(new NullPointerException());
    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误!"));
    ErrorResponse resourceNotFoundResponse = new ErrorResponse(new ResourceNotFoundException("Sorry, the resource not found!"));


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandle(Exception e) throws Exception {

        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        } else if (e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(400).body(resourceNotFoundResponse);
        } else if (e instanceof NullPointerException) {
            return ResponseEntity.status(400).body(npeResponse);
        } else {
            throw e;
        }
    }
}
