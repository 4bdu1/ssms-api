package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.service.DomainService;
import com.abduldevelops.ssms.api.domain.service.DomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public DomainService domainService(){
        return new DomainServiceImpl();
    }
}
