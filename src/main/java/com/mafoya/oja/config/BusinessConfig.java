package com.mafoya.oja.config;

import com.mafoya.oja.repository.BrandRepository;
import com.mafoya.oja.repository.CustomerRepository;
import com.mafoya.oja.repository.EmployeeRepository;
import com.mafoya.oja.repository.OrderRepository;
import com.mafoya.oja.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    @Bean
    BrandService brandService(BrandRepository brandRepository) {
        return new BrandServiceImpl(brandRepository);
    }

    @Bean
    EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeServiceImpl(employeeRepository);
    }

    @Bean
    OrderService orderService(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }

    @Bean
    CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }

}
