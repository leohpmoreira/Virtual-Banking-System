package com.lm.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Customer extends User {
    public List<BankAccount> accounts = new ArrayList<>();

    public Customer(String name, String password, String type, String manager) {
        super(name, password, type, manager);
    }

    public void newAccount(String type) {
        switch (type) {
            case "simple" -> accounts.add(new SimpleAccount(this.name, "Conta Simples"));
            case "savings" -> accounts.add(new SavingsAccount(this.name, "Conta Poupança"));
            case "special" -> accounts.add(new SpecialAccount(this.name, "Conta Especial"));
        }
    }

    public String getAccounts() {
        String str = "";
        for (BankAccount account : this.accounts) {
            str.concat("Número da conta: " + account.getAccNumber() + "\nTipo: " + account.getType() + "\nSaldo: R$" + account.getBalance() + "\nTransações: " + account.getTransactions() + "\n");
        }
        return str;
    }
}
