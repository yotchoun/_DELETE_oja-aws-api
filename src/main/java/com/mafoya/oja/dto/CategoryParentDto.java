package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class CategoryParentDto {


    private String id;

    private Instant createdAt;

    private String categoryId;


    private String featured;


    private String description;

    private String slug;


    private String image;


    private String icon;


    private String name;

}
