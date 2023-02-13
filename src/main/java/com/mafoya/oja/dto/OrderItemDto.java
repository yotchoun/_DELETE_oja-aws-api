package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class OrderItemDto{
    private String id;
    private Instant createdAt;
    private String product_name;
    private Float product_price;
    private Integer product_quantity;
    private String orderId;
}
