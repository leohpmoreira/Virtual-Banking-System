package com.lm.bank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InfoUserController implements Initializable {
    private Manager current = (Manager) LoginController.user;

    @FXML
    private ListView<BankAccount> contas;

    @FXML
    private ComboBox<Customer> clientes;

    @FXML
    private Button exit;

    @FXML
    void getBox(){
        List<BankAccount> cont = clientes.getSelectionModel().getSelectedItem().getAccounts();
        ObservableList<BankAccount> obsCont = FXCollections.observableList(cont);
        contas.setItems(obsCont);
    }

    @FXML
    void close(){
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadBox();
    }

    void loadBox(){
        ObservableList<Customer> obsCli = FXCollections.observableList(current.customersOwned());
        clientes.setItems(obsCli);
    }
}
