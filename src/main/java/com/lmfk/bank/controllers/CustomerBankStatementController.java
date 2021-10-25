package com.lmfk.bank.controllers;

import com.lmfk.bank.BankAccount;
import com.lmfk.bank.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerBankStatementController implements Initializable {
    private Customer current = (Customer) LoginController.user;

    @FXML
    private ComboBox<BankAccount> comboBox;

    @FXML
    private Button close;

    @FXML
    private ListView<String> listView;

    @FXML
    void getInfo() {
        BankAccount currentAcc = comboBox.getSelectionModel().getSelectedItem();
        ObservableList<String> obsTransactions = FXCollections.observableList(currentAcc.getTransactions());
        listView.setItems(obsTransactions);
    }

    @FXML
    void close() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();
    }

    void loadComboBox() {
        ObservableList<BankAccount> obsBank = FXCollections.observableList(current.getAccounts());
        comboBox.setItems(obsBank);
    }
}
