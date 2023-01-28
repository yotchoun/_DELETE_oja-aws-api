package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Order;
import com.mafoya.oja.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/all")
    public PageIterable<Order> findAll(@RequestHeader("authorization") String authorization, @PathVariable String customerID, @PathVariable String orderID) {
        return this.orderService.getAll(authorization, customerID, orderID);
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@RequestHeader("authorization") String authorization, @PathVariable String customerID, @PathVariable String orderID) {
        return this.orderService.getById(authorization, customerID, orderID);

    }

    @PostMapping("/orders")
    public void createOrder(@RequestHeader("authorization") String authorization, @RequestBody Order order) {
        this.orderService.create(authorization, order);
    }

    @DeleteMapping("/orders/{id}")
    public void updateOrder(@PathVariable String id, @RequestHeader("authorization") String authorization, @PathVariable String customerID, @PathVariable String orderID) {
        this.orderService.delete(authorization, customerID, orderID);
    }

}
