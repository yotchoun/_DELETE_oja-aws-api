package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class ProductStockOutDto {
    private String id;
    private Instant createdAt;
    private Float amount;
    private String stock;
    private String product;
}
