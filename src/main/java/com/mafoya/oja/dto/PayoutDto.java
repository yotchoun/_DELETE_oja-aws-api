package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class PayoutDto {

    private String id;

    private Instant createdAt;

    private String sellerInfo;

    private String payment;

    private String date;

    private String amount;

    private String no;





}
