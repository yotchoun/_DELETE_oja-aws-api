package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.Order;
import com.mafoya.oja.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<Order> findAll(@RequestHeader("authorization") String authorization) {
        return this.orderService.getAll(authorization);
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> getOrderById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.orderService.getById(authorization, id);

    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody @Valid Order orderDto, @RequestHeader("authorization") String authorization) {
        return this.orderService.create(authorization, orderDto);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody Order order) {
        return this.orderService.update(authorization, order, id);


    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.orderService.delete(authorization, id);
    }
}

