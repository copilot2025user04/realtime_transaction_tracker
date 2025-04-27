package com.ey.bank.realtime_transaction_tracker.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter

public class Account {

    public static enum AccountType {
        SAVINGS, CURRENT, LOAN;
    }

    private Long accountId;

    private String accountHolderName;
    private AccountType accountType;
    private String branchName;
    private String ifscCode;

    // Additional fields and methods can be added as needed
}
