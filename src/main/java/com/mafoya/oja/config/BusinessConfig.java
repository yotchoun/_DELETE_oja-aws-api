package com.mafoya.oja.config;

import com.mafoya.oja.repository.BrandRepository;
import com.mafoya.oja.repository.UserRepository;
import com.mafoya.oja.repository.NavigationRepository;
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
    NavigationService NavigationService(NavigationRepository navigationRepository) {
        return new NavigationServiceImpl(navigationRepository);
    }

    @Bean
    OrderService orderService(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }

    @Bean
    UserService customerService(UserRepository customerRepository) {
        return new UserServiceImpl(customerRepository);
    }

}
