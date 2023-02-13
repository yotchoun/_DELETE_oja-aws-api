package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class EarningDto {
    private String id;
    private Instant createdAt;
    private Integer no;
    private Float sellerEarning;
    private Float adminCommission;
    private String orderNo;
    private String shopName;
}
