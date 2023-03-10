package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class BrandDto {
    private String id;
    private Instant createdAt;
    private String slug;
    private String name;
    private String image;
    private String type;
    private Boolean featured;
    private String forId;
    private ForDto displayFor;
}
