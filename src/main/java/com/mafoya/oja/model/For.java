package com.mafoya.oja.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class For {

    @DynamoDBAttribute(attributeName = "demo")
    private String demo;

    @DynamoDBAttribute(attributeName = "type")
    private String type;
}
