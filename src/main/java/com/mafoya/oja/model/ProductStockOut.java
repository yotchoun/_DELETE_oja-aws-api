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
@DynamoDBTable(tableName = "OjaProductStockOut-hvlboaadvrhhpi7zd6mqvplo6e-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockOut {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;


    @DynamoDBAttribute(attributeName = "product")
    private String product;

    @DynamoDBAttribute(attributeName = "stock")
    private String stock;

}
