package com.ey.bank.realtime_transaction_tracker.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
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
