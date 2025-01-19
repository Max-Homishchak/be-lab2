package com.khomishchak.belab2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private Long id;
    private Long userId;
    private Long categoryId;
    private LocalDateTime createdAt;
    private BigDecimal amount;
}
