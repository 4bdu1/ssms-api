package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.port.output.repository.StudentRepository;
import com.abduldevelops.ssms.api.domain.service.DomainService;
import com.abduldevelops.ssms.api.domain.service.DomainServiceImpl;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.abduldevelops.ssms")
public class StudentTestConfiguration {
    @Bean
    public StudentRepository studentRepository(){
        return Mockito.mock(StudentRepository.class);
    }

    @Bean
    public DomainService domainService(){
        return new DomainServiceImpl();
    }
}
