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
@DynamoDBTable(tableName = "OjaOrder-hvlboaadvrhhpi7zd6mqvplo6e-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;
    @DynamoDBAttribute(attributeName = "tax")
    private double tax;
    @DynamoDBAttribute(attributeName = "discount")
    private double discount;
    @DynamoDBAttribute(attributeName = "isDelivered")
    private double isDelivered;
    @DynamoDBAttribute(attributeName = "totalPrice")
    private double totalPrice;
    @DynamoDBAttribute(attributeName = "shippingAddress")
    private double shippingAddress;
    @DynamoDBAttribute(attributeName = "status")
    private double status;
    @DynamoDBAttribute(attributeName = "deliveredAt")
    private double deliveredAt;
    @DynamoDBAttribute(attributeName = "userId")
    private String userId;
}









