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
public class CustomerDetail {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerEmail;
}
