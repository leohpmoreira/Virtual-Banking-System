package com.lmfk.bank.controllers;

import com.lmfk.bank.*;
import com.lmfk.bank.controllers.LoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManagerNewUserController implements Initializable {
    Manager current_user = (Manager) LoginController.user;

    @FXML
    private TextField username, password;

    @FXML
    private ComboBox<String> userType;

    @FXML
    private Button okButton;

    @FXML
    void getInfo() {
        String name = username.getText();
        String pass = password.getText();
        Alert alert = null;
        Stage stage = (Stage) okButton.getScene().getWindow();
        for (User user : Main.users) {
            if (user.getName().equals(name)) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Usuário Invalido");
                break;
            }
        }
        if (alert == null) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Usuário cadastrado com sucesso");
            switch (userType.getSelectionModel().getSelectedItem()) {
                case "Gerente" -> {
                    Manager novo = new Manager(username.getText(), password.getText(), "Gerente", current_user.getName());
                    //writeFile(novo, "Gerente");
                    Main.users.add(novo);
                    System.out.println("store");
                    Encryption.storeUsers(novo);
                }
                case "Cliente" -> {
                    Customer novo = new Customer(username.getText(), password.getText(), "Cliente", current_user.getName());
                    //writeFile(novo, "Cliente");
                    Main.users.add(novo);
                    System.out.println("store");
                    Encryption.storeUsers(novo);
                }
            }
        }
        alert.showAndWait();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadBox();
    }

    void loadBox() {
        ObservableList<String> obsType;
        List<String> type = new ArrayList<>();
        type.add("Gerente");
        type.add("Cliente");
        obsType = FXCollections.observableList(type);
        userType.setItems(obsType);
    }

    /*void writeFile(User user, String tipo) {
        File arquivo = new File("users.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            BufferedWriter dataW = new BufferedWriter(new FileWriter(arquivo, true));
            dataW.write(user.getName() + "-" + user.getPassword() + "-" + user.getType() + "-" + user.getManager());
            dataW.newLine();
            dataW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

