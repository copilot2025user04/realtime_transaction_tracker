package com.ey.bank.realtime_transaction_tracker.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDetail {

    public static enum TransactionType {
        UPI, NIFT, IMPS,RTGS, INTERNAL;
    }
    public UUID uuid;
    public Account account;
    public BenefAccount benefetryAccount;
    public TransactionType transactionType;

    public BigDecimal amount;

    public LocalDateTime timeStamp;

    public boolean balenceCheckStatus;

    public  boolean transLimitChkStatus;
     public String status;

}
