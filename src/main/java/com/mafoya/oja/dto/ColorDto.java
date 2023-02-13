package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class ColorDto {
    private String id;
    private Instant createdAt;
    private String productId;
    private String name;
}
