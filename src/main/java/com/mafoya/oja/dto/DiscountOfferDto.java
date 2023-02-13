package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class DiscountOfferDto {
    private String id;
    private Instant createdAt;
    private String title;
    private String discountOffer;
    private String imgUrl;
    private String buttonText;
}
