package com.lm.bank;

public abstract class User {
    private String name;
    private String password;
    private String type;
    private String manager;

    public User(String name, String password, String type, String manager) {
        this.name = name;
        this.password = password;
        this.type = type;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setType(String type) {
        this.type = type;
    }

    public boolean authentication (String username, String password){
        return this.name.equals(username) && this.password.equals(password);
    }
}
