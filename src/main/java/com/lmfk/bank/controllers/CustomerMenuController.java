package com.lmfk.bank.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerMenuController {
    @FXML
    private Button sair;

    @FXML
    protected void goAddAccount(ActionEvent e) throws IOException {
        loadScene("/User/AddAccountMenu.fxml");
    }

    @FXML
    protected void goDeposito() throws IOException {
        loadScene("/Customer/CustomerDeposit.fxml");
    }

    @FXML
    protected void goSacar() throws IOException {
        loadScene("/Customer/CustomerWithdrawn.fxml");
    }

    @FXML
    protected void goSaldo() throws IOException {
        loadScene("/Customer/CustomerBalance.fxml");
    }

    @FXML
    protected void goExtrato() throws IOException {
        loadScene("/Customer/CustomerBankStatement.fxml");
    }

    @FXML
    protected void goAlteraSenha() throws IOException {
        loadScene("/User/UserChangePassword.fxml");
    }

    @FXML
    void sair() throws IOException {
        Stage atual = (Stage) sair.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        atual.close();
        stage.show();
    }

    private void loadScene(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.showAndWait();
    }
}
