package com.ey.bank.realtime_transaction_tracker;

import com.ey.bank.realtime_transaction_tracker.dao.TransactionRequest;
import com.ey.bank.realtime_transaction_tracker.entity.WithdrawalDocument;
import com.ey.bank.realtime_transaction_tracker.repo.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class KafkaListener {

    @Autowired
    private WithdrawalRepository repository;

    @Bean
    public Consumer<TransactionRequest> processTransaction() {
        return transactionRequest -> {
            System.out.println("Received transaction: " + transactionRequest);
            WithdrawalDocument doc = new WithdrawalDocument(
                    transactionRequest.getAccountNumber(),
                    transactionRequest.getAmount(),
                    transactionRequest.getTimestamp()
            );
            System.out.println("WithdrawalDocument transaction: " + doc);
            repository.save(doc).subscribe();
        };
    }
}
