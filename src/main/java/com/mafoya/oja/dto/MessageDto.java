package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class MessageDto{
    private String id;
    private Instant createdAt;
    private String imgUrl;
    private String name;
    private String text;
    private Instant date;
}
