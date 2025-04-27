package com.ey.bank.realtime_transaction_tracker.dao;


import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class BenefAccount {
    public static enum AccountType {
        SAVINGS, CURRENT, LOAN;
    }
    private Long accountId;
    private String accountHolderName;
    private BenefAccount.AccountType accountType;
    private String bankName;
    private String branchName;
    private String ifscCode;
    private double balance;
}
