package com.lmfk.bank.controllers;

import com.lmfk.bank.service.BankAccount;
import com.lmfk.bank.service.Customer;
import com.lmfk.bank.service.Manager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.util.ResourceBundle;

public class ManagerWithdrawController implements Initializable {
    private final Manager current = (Manager) LoginController.user;

    @FXML
    private ComboBox<Customer> cliente;

    @FXML
    private ComboBox<BankAccount> conta;

    @FXML
    private TextField value;

    @FXML
    private Button apply;

    @FXML
    void getCliente() {
        loadConta();
    }

    @FXML
    void getValue() {
        value.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    value.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    void withdrawn() {
        double valor;
        Stage stage = (Stage) apply.getScene().getWindow();
        BankAccount account = conta.getSelectionModel().getSelectedItem();
        if (value.getText().isEmpty()) {
            return;
        } else {
            valor = Double.parseDouble(value.getText());
            if (valor >= 110000) {
                if (account.testWithdraw(valor)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Sucesso");
                    alert.setContentText("Saque realizado com sucesso");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Erro");
                    alert.setContentText("Saque negado");
                    alert.showAndWait();
                }
            }
            stage.close();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCliente();
    }

    void loadCliente() {
        ObservableList<Customer> obCl = FXCollections.observableList(current.customersOwned());
        cliente.setItems(obCl);
    }

    void loadConta() {
        Customer user = cliente.getSelectionModel().getSelectedItem();
        ObservableList<BankAccount> obsCn = FXCollections.observableList(user.getAccounts());
        conta.setItems(obsCn);
    }
}
