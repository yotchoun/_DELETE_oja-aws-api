package com.mafoya.oja.service;

import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.model.Order;
import com.mafoya.oja.repository.OrderRepository;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(String authorization, Order order) {
         orderRepository.save(order);
    }

    @Override
    public Order getById(String authorization, String customerID, final String orderID) {
        return orderRepository.getOrder(customerID, orderID);
    }

    @Override
    public PageIterable<Order> getAll(String authorization, String customerID, final String orderID) {
        return orderRepository.scanOrders(customerID, orderID);
    }

    @Override
    public void delete(String authorization, String customerID, final String orderID) {
        orderRepository.deleteOrder(customerID, orderID);
    }

}
