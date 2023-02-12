package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class DealOfTheWeekDto {

    private String id;

    private Instant createdAt;

    private String imgUrl;

    private String brand;

    private String off;

}
