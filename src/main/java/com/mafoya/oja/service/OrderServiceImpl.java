package com.mafoya.oja.service;

import com.mafoya.oja.dto.OrderDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Order;
import com.mafoya.oja.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto getById(String authorization, String id) {
        OrderDto orderDto;
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            orderDto = OjaMapper.mapOrderDto(orderOptional.get());
            return orderDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public OrderDto create(String authorization, OrderDto orderDto) {
        Order order = OjaMapper.mapOrderDo(orderDto);
        orderRepository.save(order);
        return orderDto;
    }

    @Override
    public OrderDto update(String authorization, OrderDto orderDto, String id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = OjaMapper.mapOrderDo(orderDto);
            order.setId(id);
            orderRepository.save(order);
            return orderDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<OrderDto> getAll(String authorization) {
        List<Order> doList = (List<Order>) orderRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        orderRepository.deleteById(id);
    }
}

