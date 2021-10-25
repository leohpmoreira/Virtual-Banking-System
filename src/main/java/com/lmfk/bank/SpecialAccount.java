package com.lmfk.bank;

public class SpecialAccount extends BankAccount {
    private double credit;

    public SpecialAccount(String owner, String type) {
        super(owner, type);
        this.credit = 0;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public boolean testWithdraw(double amount) {
        if (amount <= this.balance + credit) {
            this.balance = balance - amount;
            this.transactions.add("\n-" + amount);
            return true;
        } else {
            return false;
        }
    }
}
