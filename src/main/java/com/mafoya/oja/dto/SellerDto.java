package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class SellerDto {

    private String id;

    private Instant createdAt;

    private String published;

    private String packages;

    private String shopName;

    private String name;

    private String balance;

    private String phone;

}
