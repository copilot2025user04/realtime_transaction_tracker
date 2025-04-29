package com.ey.bank.realtime_transaction_tracker.repo;

import com.ey.bank.realtime_transaction_tracker.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {
    // Custom queries can be added here if needed

}