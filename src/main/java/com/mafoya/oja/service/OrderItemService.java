package com.mafoya.oja.service;

import com.mafoya.oja.dto.OrderItemDto;

import java.util.List;
import java.util.Set;

public interface OrderItemService {
    OrderItemDto create(String authorization, OrderItemDto orderItemDto);

    OrderItemDto update(String authorization, OrderItemDto orderItemDto, String id);

    OrderItemDto getById(String authorization, String id);

    List<OrderItemDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<OrderItemDto> findByOrderId(String authorization,String id);
}
