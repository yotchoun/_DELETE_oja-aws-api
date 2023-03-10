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
@DynamoDBTable(tableName = "OjaOrder-tdkjweejdrbvpdpqy72fsp6a2y-dev")
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
    private Integer discount;
    @DynamoDBAttribute(attributeName = "isDelivered")
    private Boolean isDelivered;
    @DynamoDBAttribute(attributeName = "totalPrice")
    private Float totalPrice;
    @DynamoDBAttribute(attributeName = "shippingAddress")
    private String  shippingAddress;
    @DynamoDBAttribute(attributeName = "status")
    private String status;
    @DynamoDBAttribute(attributeName = "deliveredAt")
    private Instant deliveredAt;
    @DynamoDBAttribute(attributeName = "userId")
    private String userId;
}









