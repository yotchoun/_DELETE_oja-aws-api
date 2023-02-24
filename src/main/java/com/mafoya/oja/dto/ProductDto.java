package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;

@Data
@ToString
public class ProductDto {
    private String id;
    private Instant createdAt;
    private Integer size;
    private String brand;
    private String title;
    private String slug;
    private Float price;
    private Integer discount;
    private Integer rating;
    private String status;
    private String thumbnail;
    private Integer unit;
    private String shopId;
    private Boolean published;
    private ShopDto shop;
    private Set<ImageDto> images;
    private Set<CategoryDto> categories;
    private Set<ReviewDto> reviews;




}