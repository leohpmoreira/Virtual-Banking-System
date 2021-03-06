package com.lmfk.bank.controllers;

import com.lmfk.bank.service.BankAccount;
import com.lmfk.bank.service.Customer;
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

public class CustomerDepositController implements Initializable {
    Customer usuario = (Customer) LoginController.user;
    private ObservableList<BankAccount> obsContas;
    private BankAccount currentAccount;

    @FXML
    private ComboBox<BankAccount> comboBox;

    @FXML
    private Button okButton;

    @FXML
    private TextField value;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();
    }

    @FXML
    public void getInfo() {
        currentAccount = comboBox.getSelectionModel().getSelectedItem();
        value.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    value.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        if (currentAccount != null)
            okButton.setDisable(false);
    }

    public void loadComboBox() {
        obsContas = FXCollections.observableList(usuario.getAccounts());
        comboBox.setItems(obsContas);
    }


    @FXML
    public void closeDeposit() {
        double valor;
        Stage stage = (Stage) okButton.getScene().getWindow();
        Alert alert;
        if (!value.getText().isEmpty()) {
            valor = Double.parseDouble(value.getText());
            if (valor > 0) {
                currentAccount.depositar(valor);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operacao confirmada");
                alert.setHeaderText("Sucesso");
                alert.setContentText("Operacao de Deposito Realizada com sucesso");
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Operacao Interrompida");
                alert.setHeaderText("Falhou");
                alert.setContentText("Valor invalido");
            }
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Operacao Interrompida");
            alert.setHeaderText("Falhou");
            alert.setContentText("Valor nao inserido");
        }
        alert.showAndWait();
        stage.close();
    }

}
