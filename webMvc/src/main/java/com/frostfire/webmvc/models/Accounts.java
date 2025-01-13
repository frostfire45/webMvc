package com.frostfire.webmvc.models;

import java.util.List;

public class Accounts {
    // Accounts holds the list of accounts
    private List<Account> accounts;

    public Accounts() { }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
