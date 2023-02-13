package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class ShopServiceObjectDto {
    private String id;
    private Instant createdAt;
    private String icon;
    private String title;
    private String description;
}
