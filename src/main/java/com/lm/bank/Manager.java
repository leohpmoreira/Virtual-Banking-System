package com.lm.bank;

import java.util.ArrayList;
import java.util.List;

public class Manager extends User {
    //private List<Customer> customers = new ArrayList<>();

    public Manager(String name, String password, String type, String manager) {
        super(name, password, "Gerente", manager);
    }
}
