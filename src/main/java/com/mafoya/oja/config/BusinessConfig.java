package com.mafoya.oja.config;

import com.mafoya.oja.repository.EmployeeRepository;
import com.mafoya.oja.service.EmployeeService;
import com.mafoya.oja.service.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    @Bean
    EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeServiceImpl(employeeRepository);
    }

}
