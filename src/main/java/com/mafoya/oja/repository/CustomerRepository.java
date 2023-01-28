package com.mafoya.oja.repository;

import com.mafoya.oja.model.Customer;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {
}

