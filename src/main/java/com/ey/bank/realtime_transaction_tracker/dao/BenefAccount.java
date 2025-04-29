package com.ey.bank.realtime_transaction_tracker.dao;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
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
