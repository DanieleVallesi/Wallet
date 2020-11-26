package com.exercise.controller;

import com.exercise.controller.request.ChangeBalanceRequest;
import com.exercise.controller.request.CreateUserRequest;
import com.exercise.model.Transaction;
import com.exercise.model.User;
import com.exercise.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping(path = "/change-user-balance")
    public @ResponseBody ResponseEntity<Integer> changeUserBalance(@RequestBody ChangeBalanceRequest body){
        return new ResponseEntity<>(walletService.changeUserBalance(body.getUserUuid(), body.getTransactionUuid(), body.getAmmount()), HttpStatus.OK) ;
    }

    @GetMapping(path = "/transaction-history")
    public @ResponseBody ResponseEntity<List<Transaction>> getTransactionHistory(@RequestParam String userUuid){
        return new ResponseEntity<>(walletService.getTransactionHistory(userUuid), HttpStatus.OK) ;
    }

    @GetMapping(path = "/get-user-balance")
    public @ResponseBody ResponseEntity<Integer> getUserBalance(@RequestParam String userUuid){
        return new ResponseEntity<>(walletService.getUserBalance(userUuid), HttpStatus.OK) ;
    }

    @PostMapping(path = "/create-user")
    public @ResponseBody ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(walletService.createUser(createUserRequest.getUserUuid(), createUserRequest.getName(), createUserRequest.getBalance()), HttpStatus.OK);
    }

}

