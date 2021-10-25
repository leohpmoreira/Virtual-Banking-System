package com.lmfk.bank;

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


    public boolean authentication(String username, String password) {
        return this.name.equals(username) && this.password.equals(password);
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
        } else {
            System.out.println("Senha invalida");
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
