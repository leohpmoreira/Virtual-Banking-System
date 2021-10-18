package com.lm.bank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManagerNewUserController implements Initializable {
    Manager current_user = (Manager) LoginController.user;

    @FXML
    private TextField username,password;

    @FXML
    private ComboBox<String> userType;

    @FXML
    private Button okButton;

    @FXML
    void getInfo(){
        String name = username.getText();
        String pass = password.getText();
        Alert alert=null;
        Stage stage = (Stage) okButton.getScene().getWindow();
        for(User user : Main.users){
            if (user.getName().equals(name)){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Usuario Invalido");
                break;
            }
        }
        if(alert == null){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Usuario cadastrado com sucesso");
            switch (userType.getSelectionModel().getSelectedItem()){
                case "Manager" -> {
                    Manager novo = new Manager(username.getText(),password.getText(),"Gerente",current_user.getName());
                    Main.users.add(novo);
                }
                case "Customer" -> {
                    Customer novo = new Customer (username.getText(),password.getText(),"Cliente",current_user.getName());
                    Main.users.add(novo);
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

    void loadBox(){
        ObservableList<String> obsType;
        List<String> type = new ArrayList<>();
        type.add("Manager");
        type.add("Customer");
        obsType = FXCollections.observableList(type);
        userType.setItems(obsType);
    }
}

