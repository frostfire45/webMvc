package com.frostfire.webmvc.models.hibernate;

import com.frostfire.webmvc.models.Transaction;

import java.util.List;

public interface BankTransactionDao {
    Transaction store(Transaction transaction);
    void delete(Long courseId);
    Transaction findById(Long id);
    List<Transaction> findAll();
}
