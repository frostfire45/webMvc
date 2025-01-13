package com.frostfire.webmvc.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    public static Transaction testTransaction =  new Transaction(1,"Test1","12/3/2024","24.99","21","This Is a Test");

    @Test
    public void testContructorWithString(){
        Transaction transaction = new Transaction(1,"Test1","12/3/2024","24.99","21","This Is a Test");
        assertEquals(transaction.getDate(), LocalDate.of(2024,12,3));
        System.out.println("Test 1 Over");
    }
    @Test
    public void testConstructorWithBothStringAndDate(){
        Transaction transactionWithString = new Transaction(1,
                "Test1","12/3/2024","24.99","21","This Is a Test");
        Transaction transactionWithoutDateString = new Transaction(1,"Test1",LocalDate.of(2024,12,3),24.99,21,"This Is a Test");
        System.out.println("Test 2 Over");
        assertEquals(transactionWithString.getDate(), transactionWithoutDateString.getDate());
    }
    @Test
    public void testWithMissingValue(){
        Transaction transaction = new Transaction(1,"Test1","","","21","This Is a Test");
        System.out.println("Test 3 Over");
        assertFalse(transaction.equals(new Transaction(1,"Test1","12/3/2024","24.99","21","This Is a Test")));
    }
    @Test
    public void testWithNullAmount(){
        Transaction tran = new Transaction(1,"Test1","12/3/2024","","21","This Is a Test");
        System.out.println("Test 4 Over");
        assertFalse(tran.equals(testTransaction));
    }

}