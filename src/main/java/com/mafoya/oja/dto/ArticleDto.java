package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class ArticleDto {

    private String id;


    private Instant createdAt;


    private String title;


    private String description;


    private String shopId;

    private String thumbnail;


    private String slug;


    private String userId;


}
