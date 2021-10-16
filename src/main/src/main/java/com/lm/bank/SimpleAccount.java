package com.lm.bank;

public class SimpleAccount extends BankAccount {

    public SimpleAccount(String owner, String type) {
        super(owner, type);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= this.balance) {
            balance -= amount;
            this.transactions.add("\n-" + amount);
        }
        else{
            System.out.println("Saldo insuficiente");
        }
    }
}
