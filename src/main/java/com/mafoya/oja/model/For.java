package com.mafoya.oja.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class For {

    @DynamoDBAttribute(attributeName = "demo")
    private String demo;

    @DynamoDBAttribute(attributeName = "type")
    private String type;
}
