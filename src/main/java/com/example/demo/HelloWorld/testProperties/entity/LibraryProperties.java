package com.example.demo.HelloWorld.testProperties.entity;

import com.example.demo.HelloWorld.book.entity.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author maxiao
 */
@Component
@ConfigurationProperties(prefix = "library")
@Getter
@Setter
public class LibraryProperties {

    private String location;
    private List<Book> books;

}
