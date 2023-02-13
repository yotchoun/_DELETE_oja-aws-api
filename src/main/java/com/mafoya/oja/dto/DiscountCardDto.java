package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class DiscountCardDto {
    private String id;
    private Instant createdAt;
    private String title;
    private String subTitle;
    private String imgUrl;
    private String shopUrl;
    private String bgColor;

}
