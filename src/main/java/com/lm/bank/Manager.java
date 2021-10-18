package com.lm.bank;

import java.util.ArrayList;
import java.util.List;

public class Manager extends User {

    public Manager(String name, String password, String type, String manager) {
        super(name, password, type, manager);
    }

    public void newUser(String name, String password, String type) {
        switch (type) {
            case "customer" -> Main.users.add(new Customer(name, password, "Cliente", this.name));
            case "manager" -> Main.users.add(new Manager(name, password, "Gerente", this.name));
        }
    }

    public List<Customer> customersOwned() {
        String names = "";
        List<Customer> customer = new ArrayList<>();
        for (User user : Main.users) {
            if (user.getManager().equals(this.name) && user.getType().equals("Cliente")) {
                customer.add((Customer) user);
            }
        }
        if(!customer.isEmpty())
            return customer;
        else
            return null;
    }

    public void adjustCredit(String customerName, String accNum, double credit) {
        for (User user : Main.users) {
            if (user.getName().equals(customerName)) {
                Customer customer = (Customer) user;
                for (BankAccount account : customer.accounts) {
                    if (accNum.equals(account.getAccNumber()) && account.getType().equals("Conta Especial")) {
                        SpecialAccount specialAccount = (SpecialAccount) account;
                        specialAccount.setCredit(credit);
                        break;
                    }
                }
            }
        }
    }

    public void adjustInterest(String customerName, String accNum, double interest) {
        for (User user : Main.users) {
            if (user.getName().equals(customerName)) {
                Customer customer = (Customer) user;
                for (BankAccount account : customer.accounts) {
                    if (accNum.equals(account.getAccNumber()) && account.getType().equals("Conta Poupança")) {
                        SavingsAccount savingsAccount = (SavingsAccount) account;
                        savingsAccount.setInterest(interest);
                        break;
                    }
                }
            }
        }
    }
}
