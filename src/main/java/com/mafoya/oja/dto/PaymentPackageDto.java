package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class PaymentPackageDto {
    private String id;
    private Instant createdAt;
    private Integer no;
    private Instant date;
    private String seller;
    private String packages;
    private Float amount;
    private String payment;

}
