package com.frostfire.webmvc.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Transaction {
    private long id;
    private String payee;
    private LocalDate date;
    private double amount;
    private int checkNumber;
    private String memo;

    public Transaction(long id, String payee, LocalDate date, double amount, int checkNumber, String memo) {
        this.id = id;
        this.payee = payee;
        this.date = date;
        this.amount = amount;
        this.checkNumber = checkNumber;
        this.memo = memo;
    }
    public Transaction(long id, String payee, String date, String amount, String checkNumber,String memo){
        try {
            this.id = id;
            this.payee = payee;
            this.date = setStringDateToDate(date);
            this.amount = Double.parseDouble(amount);
            this.checkNumber = Integer.parseInt(checkNumber);
            this.memo = memo;
        } catch (NumberFormatException e) {
            System.out.println("Amount or check number issue: " + e );
        }
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {}

    public String getPayee() {return payee;}
    public void setPayee(String payee) {}

    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    public LocalDate setStringDateToDate(String date){
        try {
            String[] dateSplit = date.split("/");
            int year = Integer.parseInt(dateSplit[2]);
            int month = Integer.parseInt(dateSplit[0]);
            int day = Integer.parseInt(dateSplit[1]);
            LocalDate ld = LocalDate.of(year,month,day);
            return ld;
        } catch (DateTimeParseException ex){
            System.out.println(ex);
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Date is empty or misformed: " +  ex);
        }
        return null;
    }

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}
    public int getCheckNumber() {return checkNumber;}
    public void setCheckNumber(int checkNumber) {this.checkNumber = checkNumber;}

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
