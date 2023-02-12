package com.mafoya.oja.dto;


import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class OrderDto {
    private String id;

    private Instant createdAt;

    private double tax;

    private double discount;

    private double isDelivered;

    private double totalPrice;

    private double shippingAddress;

    private double status;

    private double deliveredAt;

    private String userId;

}









