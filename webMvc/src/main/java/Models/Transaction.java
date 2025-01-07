package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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
        this.id = id;
        this.payee = payee;
        this.date = setStringDateToDate(date);
    }

    private LocalDate setStringDateToDate(String date){
        try {
            String[] dateSplit = date.split("/");
            int year = Integer.parseInt(dateSplit[2]);
            int month = Integer.parseInt(dateSplit[0]);
            int day = Integer.parseInt(dateSplit[1]);
            LocalDate ld = LocalDate.of(year,month,day);
            return ld;
        } catch (DateTimeParseException ex){
            System.out.println(ex);
        }
        return null;
    }
}
