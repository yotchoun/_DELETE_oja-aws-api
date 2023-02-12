package com.mafoya.oja.service;

import com.mafoya.oja.dto.OrderItemDto;

import java.util.List;

public interface OrderItemService {
    OrderItemDto create(String authorization, OrderItemDto orderItemDto);

    OrderItemDto update(String authorization, OrderItemDto orderItemDto, String id);

    OrderItemDto getById(String authorization, String id);

    List<OrderItemDto> getAll(String authorization);

    void delete(String authorization, String id);
}
