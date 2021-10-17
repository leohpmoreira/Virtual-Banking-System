package com.lm.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Customer extends User {
    private List<BankAccount> accounts = new ArrayList<>();

    public Customer(String name, String password, String type, String manager) {
        super(name, password, "Cliente", manager);
    }

    public void newAccount (String type){
        switch (type){
            case "simple" -> accounts.add(new SimpleAccount(this.getName(), "Conta Simples"));
            case "savings" -> accounts.add(new SavingsAccount(this.getName(), "Conta Poupança"));
            case "special" -> accounts.add(new SpecialAccount(this.getName(), "Conta Especial"));
        }
    }

    public List<BankAccount> getAccounts(){return accounts;}
}
