package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;

@Data
@ToString
public class CategoryDto {
    private String id;
    private Instant createdAt;
    private String name;
    private String slug;
    private String icon;
    private String image;
    private String description;
    private Boolean featured;
    private String forId;
    private String productId;
    private ForDto displayFor;
    private Set<CategoryParentDto> parent;

}

