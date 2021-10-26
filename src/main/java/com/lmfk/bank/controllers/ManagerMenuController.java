package com.lmfk.bank.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerMenuController {
    private FXMLLoader loader;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button sair;

    @FXML
    void infoUser() throws IOException {
        loadScene("/User/InfoUser.fxml");
    }

    @FXML
    void infoConta() throws IOException {
        loadScene("/User/infoConta.fxml");
    }

    @FXML
    void applyMoney() throws IOException {
        loadScene("/User/ApplyMoney.fxml");
    }

    @FXML
    void transfer() throws IOException {
        loadScene("/Manager/Transfer.fxml");
    }

    @FXML
    void withdrawnFromAcc() throws IOException {
        loadScene("/Manager/ManagerWithdrawn.fxml");
    }

    @FXML
    void editInfo() throws IOException {
        loadScene("/Manager/ManagerInfoUser.fxml");
    }

    @FXML
    void newUser() throws IOException {
        loadScene("/Manager/ManagerNewUser.fxml");
    }

    @FXML
    void changePassword() throws IOException {
        loadScene("/User/UserChangePassword.fxml");
    }

    @FXML
    void sair() throws IOException {
        Stage atual = (Stage) sair.getScene().getWindow();
        loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        stage = new Stage();
        scene = new Scene(loader.load());
        stage.setScene(scene);
        atual.close();
        stage.show();
    }

    void loadScene(String path) throws IOException {
        loader = new FXMLLoader(getClass().getResource(path));
        stage = new Stage();
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.showAndWait();
    }

}
