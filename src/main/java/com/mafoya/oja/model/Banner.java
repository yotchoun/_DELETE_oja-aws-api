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
@DynamoDBTable(tableName = "OjaBanner-hvlboaadvrhhpi7zd6mqvplo6e-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Banner {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;

    @DynamoDBAttribute(attributeName = "buttonText")
    private String buttonText;

    @DynamoDBAttribute(attributeName = "thumbnail")
    private String thumbnail;


    @DynamoDBAttribute(attributeName = "description")
    private String description;


    @DynamoDBAttribute(attributeName = "title")
    private String title;


}
