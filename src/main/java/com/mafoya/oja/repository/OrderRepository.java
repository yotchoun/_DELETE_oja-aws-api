package com.mafoya.oja.repository;


import com.mafoya.oja.model.Order;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableScan
@Repository
public interface OrderRepository extends CrudRepository<Order, String> {

    Set<Order> findByUserId(String id);
}
