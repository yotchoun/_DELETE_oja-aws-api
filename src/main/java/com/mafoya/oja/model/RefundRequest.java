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
@DynamoDBTable(tableName = "OjaRefundRequest-tdkjweejdrbvpdpqy72fsp6a2y-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefundRequest {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;
    @DynamoDBAttribute(attributeName = "image")
    private String image;
    @DynamoDBAttribute(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "status")
    private String status;
    @DynamoDBAttribute(attributeName = "amount")
    private Float amount;
    @DynamoDBAttribute(attributeName = "shopName")
    private String shopName;
    @DynamoDBAttribute(attributeName = "orderNo")
    private String orderNo;
}
