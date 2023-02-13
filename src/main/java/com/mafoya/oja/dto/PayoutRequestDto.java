package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class PayoutRequestDto {
    private String id;
    private Instant createdAt;
    private Integer no;
    private Instant date;
    private String seller;
    private String message;
    private Float amount;
    private Float totalAmount;
    private Float requestAmount;
    private String shopName;
}
