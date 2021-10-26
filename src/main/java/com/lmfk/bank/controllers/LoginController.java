package com.lmfk.bank.controllers;


import com.lmfk.bank.Main;
import com.lmfk.bank.service.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    public static User user;

    @FXML
    private TextField userInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Button loginButton;

    @FXML
    protected void login() throws IOException {
        String name = userInput.getText();
        String password = passwordInput.getText();
        for (User user : Main.users) {
            if (user.authentication(name, password)) {
                Main.currentUser = user;
                break;
            }
        }
        Stage atual = (Stage) loginButton.getScene().getWindow();
        if (Main.currentUser != null) {
            if (Main.currentUser.getType().equals("Cliente")) {
                user = Main.currentUser;
                FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("/Customer/CustomerMenu.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.show();
            } else {
                if (Main.currentUser.getType().equals("Gerente")) {
                    user = Main.currentUser;
                    FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("/Manager/ManagerMenu.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                    stage.show();
                }
            }
            atual.close();
        }
    }
}
