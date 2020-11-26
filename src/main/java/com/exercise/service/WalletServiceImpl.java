package com.exercise.service;

import com.exercise.exception.custom.EntityAlreadyExistException;
import com.exercise.exception.custom.EntityDoesntExistException;
import com.exercise.exception.custom.NotEnoughBalanceException;
import com.exercise.model.Transaction;
import com.exercise.model.User;
import com.exercise.model.repository.TransactionRepository;
import com.exercise.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public int changeUserBalance(String userUuid, String transactionUuid, int ammount) {

        //check if the user exist
        User user = userRepository.findByUuid(userUuid);
        if (user == null) throw new EntityDoesntExistException("User with Uuid: " + userUuid + " doesn't exist");

        //check if transaction was already done with that Id
        if (transactionRepository.findByUuid(transactionUuid) != null)
            throw new EntityAlreadyExistException("Transaction with Uuid: " + transactionUuid + " already exist");

        //check if the user has enough money
        if (user.getBalance() + ammount < 0) {
            throw new NotEnoughBalanceException("The user has only a balance of : " + user.getBalance() + " , meanwhile it was requested a change of: " + ammount);
        }

        Transaction transaction = new Transaction(transactionUuid, new Date(), ammount, user);
        user.getTransactionList().add(transaction);
        user.setBalance(user.getBalance() + ammount);

        userRepository.save(user);

        return user.getBalance();
    }

    public int getUserBalance(String userUuid) {

        //check if the user exist
        User user = userRepository.findByUuid(userUuid);
        if (user == null) throw new EntityDoesntExistException("User with Uuid: " + userUuid + " doesn't exist");
        else return user.getBalance();
    }

    public List<Transaction> getTransactionHistory(String userUuid) {

        //check if the user exist
        User user = userRepository.findByUuid(userUuid);
        if (user == null) throw new EntityDoesntExistException("User with Uuid: " + userUuid + " doesn't exist");
        else return user.getTransactionList();
    }

    @Transactional
    public User createUser(String userUuid, String name, int balance) {

        //check ammount
        if (balance<0) throw new NotEnoughBalanceException("User can not be Created with less then 0 balance : " + balance);

        //check if the user exist
        User user = userRepository.findByUuid(userUuid);
        if (user != null) throw new EntityAlreadyExistException("User with Uuid: " + userUuid + " already exist");

        user = new User(userUuid, name, balance);
        userRepository.save(user);
        return user;
    }
}
