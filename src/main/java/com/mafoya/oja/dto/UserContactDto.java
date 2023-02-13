package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class UserContactDto {
    private String id;
    private Instant createdAt;
    private String firstName;
    private String lastName;
    private String userId;

}
