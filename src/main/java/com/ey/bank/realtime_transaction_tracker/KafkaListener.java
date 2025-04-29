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
import java.util.function.Consumer;

@Configuration
public class KafkaListener {

    @Autowired
    private WithdrawalRepository repository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Bean
    public Consumer<TransactionDetail> processTransaction() {
        return transactionDetail     -> {
            System.out.println("Received transaction: " + transactionDetail);
            if(transactionDetail.getStatus()!=null && transactionDetail.getStatus().equalsIgnoreCase("F")) {
                transactionDetail.setAmount(transactionDetail.getAmount().negate());
            }
            WithdrawalDocument doc = new WithdrawalDocument(
                   transactionDetail.getAccount().getAccountId().toString(),
                    transactionDetail.getAmount(),
                    Instant.now()
            );
            System.out.println("WithdrawalDocument transaction: " + doc);
            repository.save(doc).subscribe();
            Transaction transaction = new Transaction();
            transaction.setSenderAccount(transactionDetail.getAccount().getAccountId().toString());
            transaction.setTransactionId(transactionDetail.getUuid().toString());
            transaction.setReceiverAccount(transactionDetail.getBenefetryAccount().getAccountId().toString());
            transaction.setAmount(transactionDetail.getAmount());
            transaction.setStatus("SUCCESS");
            transactionRepository.save(transaction);
        };
    }
}
