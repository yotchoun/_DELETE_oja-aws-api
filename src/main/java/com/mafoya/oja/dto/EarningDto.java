package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class EarningDto {

    private String id;

    private Instant createdAt;

    private String no;

    private String sellerEarning;

    private String adminCommission;

    private String orderNo;

    private String shopName;

}
