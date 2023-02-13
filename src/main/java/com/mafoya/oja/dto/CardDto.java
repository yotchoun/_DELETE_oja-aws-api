package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class CardDto {

    private String id;
    private Instant createdAt;
    private String title;
    private String amount1;
    private String amount2;
    private String color;
    private String percentage;
}
