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
    boolean testWithdraw(double amount) {
        if (amount <= this.balance+credit) {
            if(amount > this.balance){
                this.balance = 0;
                this.credit = credit - (amount - balance);
            }
            else{
                this.balance = balance - amount;
            }
            this.transactions.add("\n-" + amount);
            return true;
        }
        else{
            return false;
        }
    }
}
