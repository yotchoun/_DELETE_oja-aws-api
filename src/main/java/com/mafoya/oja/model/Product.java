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
@DynamoDBTable(tableName = "OjaProduct-6izfil7vl5a77cv7qdoaxmqwey-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;
    @DynamoDBAttribute(attributeName = "size")
    private Integer size;
    @DynamoDBAttribute(attributeName = "brand")
    private String brand;
    @DynamoDBAttribute(attributeName = "title")
    private String title;
    @DynamoDBAttribute(attributeName = "slug")
    private String slug;
    @DynamoDBAttribute(attributeName = "price")
    private Float price;
    @DynamoDBAttribute(attributeName = "discount")
    private Integer discount;
    @DynamoDBAttribute(attributeName = "rating")
    private Integer rating;
    @DynamoDBAttribute(attributeName = "status")
    private String status;
    @DynamoDBAttribute(attributeName = "thumbnail")
    private String thumbnail;
    @DynamoDBAttribute(attributeName = "unit")
    private Integer unit;
    @DynamoDBAttribute(attributeName = "shopId")
    private String shopId;
    @DynamoDBAttribute(attributeName = "published")
    private Boolean published;
}