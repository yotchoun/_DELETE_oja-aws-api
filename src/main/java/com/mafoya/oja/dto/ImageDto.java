package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class ImageDto {
    private String id;
    private Instant createdAt;
    private String link;
    private String productId;
}
