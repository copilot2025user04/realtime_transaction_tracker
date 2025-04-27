package com.ey.bank.realtime_transaction_tracker.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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
