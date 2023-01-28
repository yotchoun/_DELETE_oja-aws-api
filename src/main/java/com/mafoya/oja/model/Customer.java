package com.mafoya.oja.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DynamoDBTable(tableName = "OjaCustomer-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @DynamoDBHashKey(attributeName = "CustomerID")
    private String customerID;
    @DynamoDBAttribute(attributeName = "Name")
    private String name;
    @DynamoDBAttribute(attributeName = "Email")
    private String email;


}
