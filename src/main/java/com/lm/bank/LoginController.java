package com.lm.bank;


import com.lm.bank.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

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
    protected void login() throws IOException{
        String name = userInput.getText();
        String password = passwordInput.getText();
        for (User user : Main.users) {
            if (user.authentication(name, password)) {
                Main.currentUser = user;
                break;
            }
        }
        Stage atual = (Stage) loginButton.getScene().getWindow();
        atual.close();

        if(Main.currentUser.getType().equals("Cliente")) {
            this.user = Main.currentUser;
            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("/CustomerMenu.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        }

    }
}
