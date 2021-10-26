package com.lmfk.bank.service;

public class SavingsAccount extends SimpleAccount {
    private double Interest;

    public SavingsAccount(String owner, String type) {
        super(owner, type);
        this.Interest = 0;
    }


    public double getInterest() {
        return Interest;
    }

    public void setInterest(double interest) {
        Interest = interest;
    }
}
