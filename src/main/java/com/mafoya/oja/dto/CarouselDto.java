package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@ToString
public class CarouselDto {


    private String id;


    private Instant createdAt;

    private String title;


    private String category;


    private BigDecimal discount;


    private String imgUrl;


    private String description;


    private String buttonText;



    private String buttonLink;
}
