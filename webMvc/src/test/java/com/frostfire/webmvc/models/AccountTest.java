package com.frostfire.webmvc.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    static List<Transaction> transactionList = new ArrayList<Transaction>(){{
            add(new Transaction(1,"Test1Payee","12/3/2024","12.96","1","Test 1 Payee for tst1"));
            add(new Transaction(2,"Test2Payee","12/25/2024","62.96","2","Test 2 Payee for tst2"));
    }};
    static Account goodAccount = new Account("123456","Checking", transactionList);

    @Test
    @DisplayName("Test Adding Transaction")
    public void testAddTransaction() {
        Account account = goodAccount;
        account.getTransactionList().add(new Transaction(3,"Test3Payee","12/21/2024","262.96","3","Test 3 Payee for tst2"));
        assertTrue(account.getTransactionList().size()==3);
    }
    @Test
    @DisplayName("Test Removing Transaction")
    public void testRemoveTransaction() {
        Account account = goodAccount;
        account.getTransactionList().remove(0);
        assertTrue(account.getTransactionList().size()==1);
    }

}