package com.lm.bank;

import javafx.event.ActionEvent;
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

    @FXML
    private TextField userInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Button loginButton;

    @FXML
    protected void login(ActionEvent actionEvent) throws IOException{
        String name = userInput.getText();
        String password = passwordInput.getText();
        for (User user : Main.usuario) {
            if (user.authentication(name, password)) {
                Main.currentUser = user;
                System.out.println("teste");
                break;
            }
        }
        Stage atual = (Stage) loginButton.getScene().getWindow();
        atual.close();

        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/CustomerMenu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }
}
