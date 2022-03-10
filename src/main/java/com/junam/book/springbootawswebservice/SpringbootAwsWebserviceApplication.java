package com.junam.book.springbootawswebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPAAuditing 활성화
@SpringBootApplication
public class SpringbootAwsWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsWebserviceApplication.class, args);
    }

}
