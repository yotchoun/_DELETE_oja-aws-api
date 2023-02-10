package com.mafoya.oja.service;

import com.mafoya.oja.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    OrderItem create(String authorization, OrderItem orderItem);

    OrderItem update(String authorization, OrderItem orderItem, String id);

    Optional<OrderItem> getById(String authorization, String id);

    List<OrderItem> getAll(String authorization);

    void delete(String authorization, String id);
}
