package com.lmfk.bank.controllers;

import com.lmfk.bank.service.BankAccount;
import com.lmfk.bank.service.Customer;
import com.lmfk.bank.service.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InfoContaController implements Initializable {
    private final Manager current = (Manager) LoginController.user;

    @FXML
    private ListView<String> transactions;

    @FXML
    private ComboBox<BankAccount> conta;

    @FXML
    private Label info;

    @FXML
    private Button close;

    @FXML
    void getCombo() {
        BankAccount acc = conta.getSelectionModel().getSelectedItem();
        ObservableList<String> obsExt = FXCollections.observableList(acc.getTransactions());
        transactions.setItems(obsExt);
        info.setText("Nome: " + acc.getOwner() + "\nNumero: " + acc.getAccNumber() + "\n");
    }

    @FXML
    void close() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadBox();
    }

    void loadBox() {
        List<BankAccount> acc = new ArrayList<>();
        for (Customer user : current.customersOwned()) {
            acc.addAll(user.getAccounts());
        }
        ObservableList<BankAccount> obsAcc = FXCollections.observableList(acc);
        conta.setItems(obsAcc);
    }
}
