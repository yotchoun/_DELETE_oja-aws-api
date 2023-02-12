package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;

@Data
@ToString
public class CategoryNavigationDto {
    private String id;
    private String category;
    private Instant createdAt;
    private Set<CategoryItemDto> categoryItem;
}
