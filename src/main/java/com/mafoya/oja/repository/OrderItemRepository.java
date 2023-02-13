package com.mafoya.oja.repository;

import com.mafoya.oja.model.OrderItem;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableScan
@Repository
public interface OrderItemRepository  extends CrudRepository<OrderItem, String> {

    Set<OrderItem> findByOrderId(String id);
}
