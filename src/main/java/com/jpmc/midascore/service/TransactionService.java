package com.jpmc.midascore.service;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRecordRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final UserRepository userRepository;
    private final TransactionRecordRepository transactionRecordRepository;

    public TransactionService(UserRepository userRepository,
                              TransactionRecordRepository transactionRecordRepository) {
        this.userRepository = userRepository;
        this.transactionRecordRepository = transactionRecordRepository;
    }

    public void processTransaction(Transaction transaction){
        UserRecord sender = userRepository.findById(transaction.getSenderId());
        UserRecord recipient = userRepository.findById(transaction.getRecipientId());

        if(sender != null && recipient != null){
            if(sender.getBalance() >= transaction.getAmount()){
                System.out.println("Transaction approved");
                sender.setBalance(sender.getBalance() - transaction.getAmount());
                recipient.setBalance(recipient.getBalance() + transaction.getAmount());
                userRepository.save(sender);
                userRepository.save(recipient);
                System.out.println(sender.toString());
                System.out.println(recipient.toString());
                TransactionRecord record = new TransactionRecord(sender,recipient,transaction.getAmount());
                transactionRecordRepository.save(record);
            }

        }
        System.out.println("Transaction rejected: insufficient funds");
        System.out.println(sender.toString());
        System.out.println(recipient.toString());
    }
}
