package com.lm.bank;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField userInput;
    @FXML
    private PasswordField passwordInput;

    protected void login() {
        String name = userInput.getText();
        String password = passwordInput.getText();
        for (User user : Main.users) {
            if (user.authentication(name, password)) {
                Main.currentUser = user;
                break;
            }
        }
    }
}
