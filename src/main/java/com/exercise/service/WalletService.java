package com.exercise.service;

import com.exercise.model.Transaction;
import com.exercise.model.User;

import java.util.List;

public interface WalletService {

    int changeUserBalance(String userUuid, String transactionUuid, int ammount);
    int getUserBalance(String userUuid);
    List<Transaction> getTransactionHistory(String userUuid);
    User createUser(String userUuid, String name, int balance);

}
