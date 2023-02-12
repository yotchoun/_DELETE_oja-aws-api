package com.mafoya.oja.controller;

import com.mafoya.oja.constant.OjaConstant;
import com.mafoya.oja.dto.OrderDto;
import com.mafoya.oja.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = OjaConstant.BASE_PATH, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/all")
    public List<OrderDto> findAll(@RequestHeader("authorization") String authorization) {
        return this.orderService.getAll(authorization);
    }

    @GetMapping("/orders/{id}")
    public OrderDto getOrderById(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        return this.orderService.getById(authorization, id);

    }

    @PostMapping("/orders")
    public OrderDto createOrder(@RequestBody @Valid OrderDto orderDto, @RequestHeader("authorization") String authorization) {
        return this.orderService.create(authorization, orderDto);
    }

    @PutMapping("/orders/{id}")
    public OrderDto updateOrder(@PathVariable String id, @RequestHeader("authorization") String authorization, @RequestBody OrderDto orderDto) {
        return this.orderService.update(authorization, orderDto, id);


    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@RequestHeader("authorization") String authorization, @PathVariable String id) {
        this.orderService.delete(authorization, id);
    }
}

