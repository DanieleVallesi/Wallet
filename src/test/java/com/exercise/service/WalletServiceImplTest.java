package com.exercise.service;

import com.exercise.exception.custom.EntityAlreadyExistException;
import com.exercise.exception.custom.EntityDoesntExistException;
import com.exercise.exception.custom.NotEnoughBalanceException;
import com.exercise.model.Transaction;
import com.exercise.model.User;
import com.exercise.model.repository.TransactionRepository;
import com.exercise.model.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class WalletServiceImplTest {

    @Mock
    UserRepository userRepositoryMock;

    @Mock
    TransactionRepository transactionRepositoryMock;

    @InjectMocks
    WalletServiceImpl walletServiceImpl;

    @Test
    public void changeMoneyTestPossible() {
        // Mocking
        User mockUser = new User("1", "Mark", 1000);
        when(userRepositoryMock.findByUuid("1")).thenReturn(mockUser);
        when(transactionRepositoryMock.findByUuid("1")).thenReturn(null);

        // Test
        int result = walletServiceImpl.changeUserBalance(mockUser.getUuid(), "1", 300);
        assertEquals(result, 1300);
    }

    @Test(expected = EntityAlreadyExistException.class)
    public void changeMoneyTestTransactionAlreadyPresent() {
        // Mocking
        User mockUser = new User("1", "Mark", 1000);
        Transaction mockTransaction = new Transaction("1", new Date(), 1, mockUser);
        when(userRepositoryMock.findByUuid("1")).thenReturn(mockUser);
        when(transactionRepositoryMock.findByUuid("1")).thenReturn(mockTransaction);

        // Test
        walletServiceImpl.changeUserBalance(mockUser.getUuid(), "1", 300);
    }

    @Test(expected = EntityDoesntExistException.class)
    public void changeMoneyTestUserNotPresent() {
        // Mocking
        User mockUser = new User("2", "Mark", 1000);

        // Test
        walletServiceImpl.changeUserBalance(mockUser.getUuid(), "1", 300);
    }

    @Test(expected = NotEnoughBalanceException.class)
    public void changeMoneyTestNotEnoughCredit() {
        // Mocking
        User mockUser = new User("1", "Mark", 1000);
        when(userRepositoryMock.findByUuid("1")).thenReturn(mockUser);
        when(transactionRepositoryMock.findByUuid("1")).thenReturn(null);

        // Test
        walletServiceImpl.changeUserBalance(mockUser.getUuid(), "1", -1300);
    }

    @Test
    public void getUserBalanceTestPossible() {
        // Mocking
        User mockUser = new User("1", "Mark", 1000);
        when(userRepositoryMock.findByUuid("1")).thenReturn(mockUser);

        // Test
        int balance = walletServiceImpl.getUserBalance("1");
        assertEquals(balance, 1000);
    }

    @Test(expected = EntityDoesntExistException.class)
    public void getUserBalanceTestNoUser() {
        // Mocking
        when(userRepositoryMock.findByUuid("1")).thenReturn(null);

        // Test
        walletServiceImpl.getUserBalance("1");
    }

    @Test
    public void getTransactionHistoryTestPossible() {
        // Mocking
        User mockUser = new User("1", "Mark", 1000);
        Transaction mockTransaction1 = new Transaction("1", new Date(), 1, mockUser);
        Transaction mockTransaction2 = new Transaction("2", new Date(), 2, mockUser);
        List<Transaction> mockTransactionList = new ArrayList<>();
        mockTransactionList.add(mockTransaction1);
        mockTransactionList.add(mockTransaction2);
        mockUser.setTransactionList(mockTransactionList);

        when(userRepositoryMock.findByUuid("1")).thenReturn(mockUser);

        // Test
        List<Transaction> transactionList = walletServiceImpl.getTransactionHistory(mockUser.getUuid());
        assertEquals(transactionList.size(), 2);
    }

    @Test(expected = EntityDoesntExistException.class)
    public void getTransactionTestUserNotPresent() {
        // Mocking
        when(userRepositoryMock.findByUuid("1")).thenReturn(null);

        // Test
        walletServiceImpl.getTransactionHistory("1");
    }

    @Test
    public void createUserTestPossible() {
        // Mocking
        when(userRepositoryMock.findByUuid("1")).thenReturn(null);

        // Test
        User user = walletServiceImpl.createUser("1", "Mark", 1000);
        assertEquals(user.getUuid(), "1");
        assertEquals(user.getName(), "Mark");
        assertEquals(user.getBalance(), 1000);
    }

    @Test(expected = EntityAlreadyExistException.class)
    public void createUserTestUserAlreadyPresent() {
        User mockUser = new User("1", "Mark", 1000);
        when(userRepositoryMock.findByUuid("1")).thenReturn(mockUser);

        //Test
        walletServiceImpl.createUser("1", "Mark", 1000);
    }

}
