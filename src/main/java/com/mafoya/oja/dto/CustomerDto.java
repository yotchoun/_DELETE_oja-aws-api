package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class CustomerDto {


    private String id;


    private Instant createdAt;

    private String name;

    private String orders;

    private String balance;

    private String avatar;

    private String phone;

    private String email;


}