package com.lmfk.bank;

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

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public void depositar(double amount) {
        this.balance += amount;
        this.transactions.add("\n+" + amount);
    }


    @Override
    public String toString() {
        return (accNumber + "\n" + type);
    }

    abstract boolean testWithdraw(double amount);

    public String getType() {
        return type;
    }


}
