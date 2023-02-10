package com.mafoya.oja.service;

import com.mafoya.oja.model.OrderItem;
import com.mafoya.oja.repository.OrderItemRepository;

import java.util.List;
import java.util.Optional;

public class OrderItemServiceImpl  implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem create(String authorization, OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem update(String authorization, OrderItem orderItem, String id) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public Optional<OrderItem> getById(String authorization, String id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public List<OrderItem> getAll(String authorization) {
        return (List<OrderItem>) orderItemRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        orderItemRepository.deleteById(id);
    }
}

