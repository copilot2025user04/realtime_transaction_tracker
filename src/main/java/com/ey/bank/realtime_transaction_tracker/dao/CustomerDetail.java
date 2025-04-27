package com.ey.bank.realtime_transaction_tracker.dao;

import lombok.Data;

@Data
public class CustomerDetail {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerEmail;
}
