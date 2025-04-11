package com.ey.bank.realtime_transaction_tracker.repo;

import com.ey.bank.realtime_transaction_tracker.entity.WithdrawalDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WithdrawalRepository extends ReactiveMongoRepository<WithdrawalDocument, String> {
}