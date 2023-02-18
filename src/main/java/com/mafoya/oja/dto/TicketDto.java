package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class TicketDto {
    private String id;
    private Instant createdAt;
    private String slug;
    private String type;
    private Instant date;
    private String title;
    private String status;
    private String category;
    private String conversation;
    private String userId;
    private ForDto displayFor;
    private UserDto user;
}
