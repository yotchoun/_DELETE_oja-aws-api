package com.mafoya.oja.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PrimaryKey {
    @DynamoDBHashKey
    private String id;

    @DynamoDBRangeKey
    private LocalDate creationDate;
}
