package com.example.demo.HelloWorld.testProperties.controller;

import com.example.demo.HelloWorld.testProperties.entity.LibraryProperties;
import com.example.demo.HelloWorld.testProperties.entity.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author maxiao
 */
@RestController
@RequestMapping("/test/pro")
public class PropertiesController {

    @Autowired
    private TestProperties testProperties;

    @Autowired
    private LibraryProperties libraryProperties;

    @GetMapping("/showUrl")
    public ResponseEntity showUrl() {
        String results = testProperties.getUrl();
        return ResponseEntity.ok(results);
    }


    @GetMapping("/getLocation")
    public ResponseEntity getLocation() {
        String results = libraryProperties.getLocation();
        System.out.println("========="+results);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/getBook")
    public ResponseEntity getBook() {
        System.out.println("========="+libraryProperties);
        return ResponseEntity.ok(libraryProperties.getBooks());
    }

}
