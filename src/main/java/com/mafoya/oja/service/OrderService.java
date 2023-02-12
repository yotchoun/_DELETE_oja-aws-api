package com.mafoya.oja.service;


import com.mafoya.oja.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto create(String authorization, OrderDto orderDto);

    OrderDto update(String authorization, OrderDto orderDto, String id);

    OrderDto getById(String authorization, String id);

    List<OrderDto> getAll(String authorization);

    void delete(String authorization, String id);
}
