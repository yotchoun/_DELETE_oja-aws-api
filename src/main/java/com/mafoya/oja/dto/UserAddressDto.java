package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class UserAddressDto {
    private String id;
    private Instant createdAt;
    private String apartNumber;
    private String title;
    private String phone;
    private String zipcode;
    private String street;
    private String state;
    private String city;
    private String country;
    private String userId;

}
