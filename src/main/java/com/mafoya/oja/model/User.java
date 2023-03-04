package com.mafoya.oja.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@DynamoDBTable(tableName = "OjaUser-tdkjweejdrbvpdpqy72fsp6a2y-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;
    @DynamoDBAttribute(attributeName = "cognitoId")
    private String cognitoId;
    @DynamoDBAttribute(attributeName = "email")
    private String email;
    @DynamoDBAttribute(attributeName = "phone")
    private String phone;
    @DynamoDBAttribute(attributeName = "avatar")
    private String avatar;
    @DynamoDBAttribute(attributeName = "picture")
    private String picture;
    @DynamoDBAttribute(attributeName = "dateOfBirth")
    private Instant dateOfBirth;
    @DynamoDBAttribute(attributeName = "verified")
    private Boolean verified;
    @DynamoDBAttribute(attributeName = "userType")
    private String userType;
    @DynamoDBAttribute(attributeName = "contactId")
    private String contactId;

}
