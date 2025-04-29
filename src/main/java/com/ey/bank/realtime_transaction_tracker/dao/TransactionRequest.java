package com.ey.bank.realtime_transaction_tracker.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequest {
    private String transactionId;
    private String sender;
    private Integer amount;
    private String receiver;
    private String status;
    // Getters and setters
}