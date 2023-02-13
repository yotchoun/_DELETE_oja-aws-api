package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class TestimonialDto {
    private String id;
    private Instant createdAt;
    private Integer rating;
    private String comment;
    private String userId;
}
