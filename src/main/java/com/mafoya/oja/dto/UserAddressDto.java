package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class UserAddressDto {

    private String id;

    private Instant createdAt;

    private String appart;

    private String country;

    private String city;

    private String type;

    private String state;

    private String phone;

    private String title;

    private String zipcode;

    private String street;

    private String userId;

}
