package com.mafoya.oja.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@ToString
public class MessageDto{

    private String id;

    private Instant createdAt;

    private Integer no;

    private BigDecimal amount;

    private String status;

    private String message;

    private Instant date;
}
