package com.graphqljava.tutorial.bookDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.graphqljava.tutorial.bookDetails")
@EnableScheduling
public class BookDetailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookDetailsApplication.class, args);
    }
}

