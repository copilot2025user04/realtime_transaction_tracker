package com.ey.bank.realtime_transaction_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.joda.time.Instant;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@ToString
@AllArgsConstructor
@Document("withdrawals")
public class WithdrawalDocument {
    private String accountNumber;
    private double amount;
    private Instant timestamp;


    // Constructors, Getters, Setters
}
