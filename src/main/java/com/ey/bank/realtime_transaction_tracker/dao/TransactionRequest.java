package com.ey.bank.realtime_transaction_tracker.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.joda.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionRequest {
    private String transactionId;
    private String sender;
    private double amount;
    private String receiver;
    // Getters and setters
}