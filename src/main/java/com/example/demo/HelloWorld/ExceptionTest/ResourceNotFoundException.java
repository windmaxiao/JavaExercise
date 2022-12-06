package com.example.demo.HelloWorld.ExceptionTest;

/**
 * @author maxiao
 * 自定义异常
 */
public class ResourceNotFoundException extends RuntimeException{

    private String massage;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.massage = message;
    }

    public String getMassage() {
        return massage;
    }

    private void setMassage(String message) {
        this.massage = message;
    }
}
