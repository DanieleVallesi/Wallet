package com.exercise.model.repository;

import com.exercise.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Transaction findByUuid(String UUId);

}
