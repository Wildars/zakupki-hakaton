package com.example.zakupkihakaton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ZakupkiHakatonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZakupkiHakatonApplication.class, args);
    }

}
