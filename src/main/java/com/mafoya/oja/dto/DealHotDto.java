package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class DealHotDto {


    private String id;

    private Instant createdAt;

    private Instant expireDate;

    private String imgUrl;

    private String productName;


}
