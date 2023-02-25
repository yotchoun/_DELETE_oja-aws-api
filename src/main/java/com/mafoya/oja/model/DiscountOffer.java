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
@DynamoDBTable(tableName = "OjaDiscountOffer-6izfil7vl5a77cv7qdoaxmqwey-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountOffer {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;
    @DynamoDBAttribute(attributeName = "title")
    private String title;
    @DynamoDBAttribute(attributeName = "discountOffer")
    private String discountOffer;
    @DynamoDBAttribute(attributeName = "imgUrl")
    private String imgUrl;
    @DynamoDBAttribute(attributeName = "buttonText")
    private String buttonText;
}
