package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class RefundRequestDto {
    private String id;
    private Instant createdAt;
    private String image;
    private String name;
    private String status;
    private Float amount;
    private String shopName;
    private String orderNo;
}
