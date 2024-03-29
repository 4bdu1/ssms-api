package com.abduldevelops.ssms.api.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.abduldevelops.ssms.api.dataaccess")
@EntityScan(basePackages = "com.abduldevelops.ssms.api.dataaccess" )
@SpringBootApplication(scanBasePackages = "com.abduldevelops.ssms")
public class StudentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }
}
