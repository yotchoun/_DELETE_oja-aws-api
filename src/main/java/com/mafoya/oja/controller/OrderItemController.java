package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.model.OrderItem;
import com.mafoya.oja.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orderItems/all")
    public List<OrderItem> findAll(@RequestHeader("authorization") String authorization) {
        return this.orderItemService.getAll(authorization);
    }

    @GetMapping("/orderItems/{id}")
    public Optional<OrderItem> getOrderItemById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.orderItemService.getById(authorization, id);

    }

    @PostMapping("/orderItems")
    public OrderItem createOrderItem(@RequestBody @Valid OrderItem orderItemDto, @RequestHeader("authorization") String authorization) {
        return this.orderItemService.create(authorization, orderItemDto);
    }

    @PutMapping("/orderItems/{id}")
    public OrderItem updateOrderItem(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody OrderItem orderItem) {
        return this.orderItemService.update(authorization, orderItem, id);


    }

    @DeleteMapping("/orderItems/{id}")
    public void deleteOrderItem(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.orderItemService.delete(authorization, id);
    }
}

