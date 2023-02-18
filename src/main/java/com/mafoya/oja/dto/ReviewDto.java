package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class ReviewDto {
    private String id;
    private Instant createdAt;
    private String customerId;
    private String productId;
    private Boolean published;
    private String comment;
    private String image;
    private String name;
    private Integer rating;

    private CustomerDto customer;

}
