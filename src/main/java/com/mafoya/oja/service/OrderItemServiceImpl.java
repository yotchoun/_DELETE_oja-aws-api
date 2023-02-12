package com.mafoya.oja.service;

import com.mafoya.oja.dto.OrderItemDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.OrderItem;
import com.mafoya.oja.model.OrderItem;
import com.mafoya.oja.repository.OrderItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderItemServiceImpl  implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItemDto getById(String authorization, String id) {
        OrderItemDto orderItemDto;
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
        if (orderItemOptional.isPresent()) {
            orderItemDto = OjaMapper.mapOrderItemDto(orderItemOptional.get());
            return orderItemDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public OrderItemDto create(String authorization, OrderItemDto orderItemDto) {
        OrderItem orderItem = OjaMapper.mapOrderItemDo(orderItemDto);
        orderItemRepository.save(orderItem);
        return orderItemDto;
    }

    @Override
    public OrderItemDto update(String authorization, OrderItemDto orderItemDto, String id) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
        if (orderItemOptional.isPresent()) {
            OrderItem orderItem = OjaMapper.mapOrderItemDo(orderItemDto);
            orderItem.setId(id);
            orderItemRepository.save(orderItem);
            return orderItemDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<OrderItemDto> getAll(String authorization) {
        List<OrderItem> doList = (List<OrderItem>) orderItemRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        orderItemRepository.deleteById(id);
    }
}

