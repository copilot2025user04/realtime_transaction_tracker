package com.ey.bank.realtime_transaction_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.joda.time.Instant;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
@Document("withdrawals")
public class WithdrawalDocument {
    private String accountNumber;
    private BigDecimal amount;
    private Instant timestamp;


    // Constructors, Getters, Setters
}
