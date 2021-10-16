package com.lm.bank;

public class SpecialAccount extends BankAccount {
    private double credit;

    public SpecialAccount(String owner, String type) {
        super(owner, type);
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    void withdraw(double amount) {
        if (amount <= this.balance+credit) {
            balance -= amount;
            this.transactions.add("\n-" + amount);
        }
        else{
            System.out.println("Saldo insuficiente");
        }
    }
}
