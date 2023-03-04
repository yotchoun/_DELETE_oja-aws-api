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
@DynamoDBTable(tableName = "OjaPayoutRequest-tdkjweejdrbvpdpqy72fsp6a2y-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayoutRequest {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;
    @DynamoDBAttribute(attributeName = "no")
    private Integer no;
    @DynamoDBAttribute(attributeName = "date")
    private Instant date;
    @DynamoDBAttribute(attributeName = "seller")
    private String seller;
    @DynamoDBAttribute(attributeName = "message")
    private String message;
    @DynamoDBAttribute(attributeName = "amount")
    private Float amount;
    @DynamoDBAttribute(attributeName = "totalAmount")
    private Float totalAmount;
    @DynamoDBAttribute(attributeName = "requestAmount")
    private Float requestAmount;
    @DynamoDBAttribute(attributeName = "shopName")
    private String shopName;
}
