package com.example.demo.HelloWorld;

import com.example.demo.HelloWorld.ExceptionTest.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maxiao
 */
@RestController
@RequestMapping("/test")
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello world";
    }

    @GetMapping("/ex")
    public void throwException() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    @GetMapping("/ex1")
    public void throwException1() {
        throw new NullPointerException();
    }

    @GetMapping("/ex2")
    public void throwException2() {
        throw new ResourceNotFoundException();
    }
}
