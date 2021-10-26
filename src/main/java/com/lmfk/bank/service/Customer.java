package com.lmfk.bank.service;

import java.util.ArrayList;
import java.util.List;

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


    public List<BankAccount> getAccounts() {
        return accounts;
    }

}
