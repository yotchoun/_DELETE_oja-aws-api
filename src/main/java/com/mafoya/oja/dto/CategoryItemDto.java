package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;

@Data
@ToString
public class CategoryItemDto {

    private String id;


    private Instant createdAt;

    private String icon;

    private String title;

    private String href;

    private String categoryItemId;

    private String categoryNavigationId;


    private Set<CategoryItemDto> child;
}


