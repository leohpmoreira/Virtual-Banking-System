package com.lm.bank;

import com.lm.bank.Main;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerDepositController implements Initializable {
    Customer usuario = (Customer) Main.currentUser;
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
        okButton.setDisable(true);
        loadComboBox();
    }

    @FXML
    public void getInfo(){
        currentAccount = comboBox.getSelectionModel().getSelectedItem();
        value.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    value.setText(newValue.replaceAll("[^\\d]",""));
                }
            }
        });
        okButton.setDisable(false);
    }

    public void loadComboBox(){
        obsContas = FXCollections.observableArrayList(usuario.getAccounts());
        comboBox.setItems(obsContas);
    }


    @FXML
    public void closeDeposit(){
        double valor;
        Stage stage = (Stage)okButton.getScene().getWindow();
        valor = Double.parseDouble(value.getText());
        currentAccount.depositar(valor);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Operacao confirmada");
        alert.setHeaderText("Sucesso");
        alert.setContentText("Operacao de Deposito Realizada com sucesso");
        stage.close();
    }

}
