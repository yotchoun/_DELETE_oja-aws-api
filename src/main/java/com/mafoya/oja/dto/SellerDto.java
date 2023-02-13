package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class SellerDto {
    private String id;
    private Instant createdAt;
    private Boolean published;
    private String packages;
    private String shopName;
    private String name;
    private Float balance;
    private String phone;
}
