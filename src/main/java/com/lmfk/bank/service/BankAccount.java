package com.lmfk.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BankAccount {
    protected String accNumber;
    protected String owner;
    protected double balance;
    protected String type;
    protected List<String> transactions = new ArrayList<>();

    public BankAccount(String owner, String type) {
        this.accNumber = String.valueOf(new Random().nextInt(999_999_999));
        this.owner = owner;
        this.balance = 0;
        this.type = type;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void depositar(double amount) {
        this.balance += amount;
        this.transactions.add("\n+" + amount);
    }


    @Override
    public String toString() {
        return (accNumber + "\n" + type);
    }

    public abstract boolean testWithdraw(double amount);

    public String getType() {
        return type;
    }


}
