package com.joseph.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDTO {
    private Long orderId;
    private BigDecimal amount;
    private BigDecimal interestRate;
    private LocalDate dueDate;
    private LocalDateTime writtenAt;
    private String author;
}
