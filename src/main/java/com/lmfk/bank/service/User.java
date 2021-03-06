package com.lmfk.bank.service;

public class User {
    protected String name;
    private String password;
    private final String type;
    private final String manager;

    public User(String name, String password, String type, String manager) {
        this.name = name;
        this.password = password;
        this.type = type;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }


    public boolean authentication(String username, String password) {
        return this.name.equals(username) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return getName();
    }
}
