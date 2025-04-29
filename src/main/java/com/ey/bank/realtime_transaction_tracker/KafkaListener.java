package com.ey.bank.realtime_transaction_tracker;

import com.ey.bank.realtime_transaction_tracker.dao.TransactionDetail;
import com.ey.bank.realtime_transaction_tracker.dao.TransactionRequest;
import com.ey.bank.realtime_transaction_tracker.entity.Transaction;
import com.ey.bank.realtime_transaction_tracker.entity.WithdrawalDocument;
import com.ey.bank.realtime_transaction_tracker.repo.TransactionRepository;
import com.ey.bank.realtime_transaction_tracker.repo.WithdrawalRepository;
import org.joda.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Consumer;

@Configuration
public class KafkaListener {

    @Autowired
    private WithdrawalRepository repository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Bean
    public Consumer<Transaction> processTransaction() {
        return transactionRequest     -> {
            System.out.println("Received transaction: " + transactionRequest);
            if(transactionRequest.getStatus()!=null && transactionRequest.getStatus().equalsIgnoreCase("F")) {
                transactionRequest.setAmount(transactionRequest.getAmount() == null ? 0 : transactionRequest.getAmount());
            }
            WithdrawalDocument doc = new WithdrawalDocument(
                    transactionRequest.getSenderAccount(),
                    transactionRequest.getAmount(),
                    Instant.now()
            );
            System.out.println("WithdrawalDocument transaction: " + doc);
            repository.save(doc).subscribe();
            if (transactionRequest.getTransactionId() == null || transactionRequest.getTransactionId().isEmpty()) {
                transactionRequest.setTransactionId(UUID.randomUUID().toString());
            }
            transactionRequest.setStatus("SUCCESS");
            System.out.println("Transaction saved: "+transactionRequest);
            transactionRepository.save(transactionRequest).subscribe();
            System.out.println("Transaction saved: "+transactionRequest);
        };
    }
}
