package com.mafoya.oja.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@DynamoDBTable(tableName = "OjaOrder-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private OrderID orderID;
    @DynamoDBHashKey(attributeName = "customerID")
    private String customerID;

    @DynamoDBRangeKey(attributeName = "orderID")
    private String orderSerial;
    @DynamoDBAttribute(attributeName = "orderValue")
    private double orderValue;

    @DynamoDBAttribute(attributeName = "createdDate")
    private Instant createdDate;

}