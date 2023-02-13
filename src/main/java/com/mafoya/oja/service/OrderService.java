package com.mafoya.oja.service;


import com.mafoya.oja.dto.OrderDto;

import java.util.List;
import java.util.Set;

public interface OrderService {

    OrderDto create(String authorization, OrderDto orderDto);

    OrderDto update(String authorization, OrderDto orderDto, String id);

    OrderDto getById(String authorization, String id);

    List<OrderDto> getAll(String authorization);

    void delete(String authorization, String id);

    Set<OrderDto> findByUserId(String authorization,String id);
}
