package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class BlogDto {
    private String id;
    private Instant createdAt;
    private String title;
    private String imgUrl;
    private String description;
    private String thumbnail;
    private String slug;
    private String shopId;
    private ShopDto shop;
    private String userId;
    private UserDto user;
}
