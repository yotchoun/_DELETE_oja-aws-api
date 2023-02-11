package com.mafoya.oja.service;


import com.mafoya.oja.model.Order;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order create(String authorization, Order order);

    Order update(String authorization, Order order, String id);

    Optional<Order> getById(String authorization, String id);

    List<Order> getAll(String authorization);

    void delete(String authorization, String id);
}
