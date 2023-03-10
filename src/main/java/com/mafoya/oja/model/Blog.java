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
@DynamoDBTable(tableName = "OjaBlog-tdkjweejdrbvpdpqy72fsp6a2y-dev")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute(attributeName = "createdAt")
    private Instant createdAt;
    @DynamoDBAttribute(attributeName = "title")
    private String title;
    @DynamoDBAttribute(attributeName = "imgUrl")
    private String imgUrl;
    @DynamoDBAttribute(attributeName = "description")
    private String description;
    @DynamoDBAttribute(attributeName = "thumbnail")
    private String thumbnail;
    @DynamoDBAttribute(attributeName = "slug")
    private String slug;
    @DynamoDBAttribute(attributeName = "shopId")
    private String shopId;
    @DynamoDBAttribute(attributeName = "userId")
    private String userId;

}
