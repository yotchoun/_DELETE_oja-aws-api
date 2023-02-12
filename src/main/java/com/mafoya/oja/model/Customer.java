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
@DynamoDBTable(tableName = "OjaCustomer-hvlboaadvrhhpi7zd6mqvplo6e-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;
    @DynamoDBAttribute(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "orders")
    private String orders;
    @DynamoDBAttribute(attributeName = "balance")
    private String balance;
    @DynamoDBAttribute(attributeName = "avatar")
    private String avatar;
    @DynamoDBAttribute(attributeName = "phone")
    private String phone;
    @DynamoDBAttribute(attributeName = "email")
    private String email;

}
