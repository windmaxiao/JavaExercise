package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author maxiao
 */
@SpringBootApplication
@MapperScan("com.example.demo.HelloWorld.DbTest.mappers")
@MapperScan("com.example.demo.HelloWorld.DbTest.dao")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
