package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class ShopDto {
    private String id;
    private Instant createdAt;
    private String slug;
    private String email;
    private String phone;
    private String address;
    private Boolean verified;
    private String coverPicture;
    private String profilePicture;
    private String userId;
    private String socialLinkId;
    private ForDto displayFor;
}
