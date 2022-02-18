package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataDemoApplication {

    public static void main(String[] args) {

        try {
            System.out.println("Test");
        } catch (Exception ex) {

        }

        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

}
