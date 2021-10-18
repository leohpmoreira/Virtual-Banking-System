package com.lm.bank;

public class SimpleAccount extends BankAccount {

    public SimpleAccount(String owner, String type) {
        super(owner, type);
    }

    @Override
    boolean withdraw(double amount) {
        if (amount <= this.balance) {
            balance -= amount;
            this.transactions.add("\n-" + amount);
            return true;
        }
        else{
            return false;
        }
    }
}
