package com.frostfire.webmvc.models;

import java.util.List;

public class Account {
    private String AccountNumber;
    private String AccountName;
    private List<Transaction> transactionList;

    public Account(String accountNumber, String accountName, List<Transaction> transactionList) {
        AccountNumber = accountNumber;
        AccountName = accountName;
        this.transactionList = transactionList;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
