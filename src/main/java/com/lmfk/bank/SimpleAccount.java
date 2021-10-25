package com.lmfk.bank;

public class SimpleAccount extends BankAccount {

    public SimpleAccount(String owner, String type) {
        super(owner, type);
    }

    @Override
    public boolean testWithdraw(double amount) {
        if (amount <= this.balance) {
            balance -= amount;
            this.transactions.add("\n-" + amount);
            return true;
        } else {
            return false;
        }
    }
}
