package com.lm.bank;

public class SavingsAccount extends SimpleAccount {
    public SavingsAccount(String owner, String type) {
        super(owner, type);
    }

    private double Interest;

    public double getInterest() {
        return Interest;
    }

    public void setInterest(double interest) {
        Interest = interest;
    }
}
