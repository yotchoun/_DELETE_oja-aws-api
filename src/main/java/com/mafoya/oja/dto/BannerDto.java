package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class BannerDto {


    private String id;


    private Instant createdAt;


    private String buttonText;


    private String thumbnail;



    private String description;


    private String title;


}
