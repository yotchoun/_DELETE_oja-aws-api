package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
public class CategoryNavigationDto {
    private String id;
    private String firstName;
    private String lastName;
    private String number;
    private String email;
    private String department;
    private double salary;
    private Set<CategoryItemDto> categoryItem;
}
