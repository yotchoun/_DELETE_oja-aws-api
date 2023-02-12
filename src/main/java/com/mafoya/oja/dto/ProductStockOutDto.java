package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class ProductStockOutDto {

    private String id;

    private Instant createdAt;

    private String product;

    private String stock;

}
