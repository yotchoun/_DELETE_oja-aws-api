package com.mafoya.oja.service;

import com.mafoya.oja.model.Order;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

public interface OrderService {

    public void create(String authorization, Order order);

    public Order getById(String authorization, String customerID, final String orderID);

    public PageIterable<Order> getAll(String authorization, String customerID, final String orderID);

    public void delete(String authorization, String customerID, final String orderID);
}
