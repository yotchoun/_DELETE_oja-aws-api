package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class CarouselDto {
    private String id;
    private Instant createdAt;
    private String title;
    private String subTitle;
    private Integer discount;
    private String category;
    private String imgUrl;
    private String description;
    private String buttonText;
    private String buttonLink;
    private String playStoreLink;
    private String appStoreLink;
}
