package com.mafoya.oja.dto;


import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class UserDto {
    private String id;
    private Instant createdAt;
    private String cognitoId;
    private String email;
    private String phone;
    private String avatar;
    private String picture;
    private Instant dateOfBirth;
    private Boolean verified;
    private String userType;
    private String contactId;
    private ForDto displayFor;

}
