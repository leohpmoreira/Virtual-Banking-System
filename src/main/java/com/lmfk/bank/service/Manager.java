package com.lmfk.bank.service;

import com.lmfk.bank.Main;

import java.util.ArrayList;
import java.util.List;

public class Manager extends User {

    public Manager(String name, String password, String type, String manager) {
        super(name, password, type, manager);
    }

    public List<Customer> customersOwned() {
        List<Customer> customer = new ArrayList<>();
        for (User user : Main.users) {
            if (user.getManager().equals(this.name) && user.getType().equals("Cliente")) {
                customer.add((Customer) user);
            }
        }
        if (!customer.isEmpty())
            return customer;
        else
            return null;
    }
}
