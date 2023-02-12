package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class SocialLinkDto {

    private String id;

    private Instant createdAt;

    private String facebook;

    private String youtube;

    private String instagram;

    private String twitter;

}
