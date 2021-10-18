package com.lm.bank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerBalanceMenu implements Initializable {
    private ObservableList<BankAccount> obsBankAcc;
    private BankAccount current;

    @FXML
    private Button close;

    @FXML
    private ComboBox<BankAccount> comboBox;

    @FXML
    private Label balance;

    @FXML
    void getComboBox(){
        current = comboBox.getSelectionModel().getSelectedItem();
        balance.setText("Saldo Atual: R$" + current.getBalance());
    }

    @FXML
    void close(){
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();
    }

    void loadComboBox(){
        obsBankAcc = FXCollections.observableList(((Customer)LoginController.user).getAccounts());
        comboBox.setItems(obsBankAcc);
    }
}
