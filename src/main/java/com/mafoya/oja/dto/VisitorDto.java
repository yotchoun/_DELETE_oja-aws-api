package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class VisitorDto {

    private String id;

    private String name;

    private Instant createdAt;

    private String stateName;

    private String page;

    private String siteName;

    private String city;

    private String countryName;

    private String countryCode;

    private String latitude;

    private String longitude;

    private String ip;
}
