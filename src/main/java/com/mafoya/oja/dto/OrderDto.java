package com.mafoya.oja.dto;


import com.mafoya.oja.model.OrderItem;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;

@Data
@ToString
public class OrderDto {
    private String id;
    private Instant createdAt;
    private double tax;
    private Integer discount;
    private Boolean isDelivered;
    private Float totalPrice;
    private String shippingAddress;
    private String status;
    private Instant deliveredAt;
    private String userId;
    private UserDto users;

    private Set<OrderItemDto> items;
}









