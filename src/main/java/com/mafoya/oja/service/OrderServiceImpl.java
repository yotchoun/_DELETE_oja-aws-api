package com.mafoya.oja.service;

import com.mafoya.oja.model.Order;
import com.mafoya.oja.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(String authorization, Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(String authorization, Order order, String id) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getById(String authorization, String id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAll(String authorization) {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        orderRepository.deleteById(id);
    }
}

