package com.ey.bank.realtime_transaction_tracker.repo;

import com.ey.bank.realtime_transaction_tracker.entity.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveCrudRepository<Transaction, String> {
    // Custom queries can be added here if needed

}