package com.lmfk.bank.controllers;

import com.lmfk.bank.*;
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

public class TransferController implements Initializable {
    private Manager user = (Manager) Main.currentUser;
    private BankAccount accScr;
    private BankAccount accDest;

    @FXML
    private TextField transferAmount;

    @FXML
    private Button transferButton;

    @FXML
    private ComboBox<Customer> sourceClient;

    @FXML
    private ComboBox<BankAccount> sourceAccount;

    @FXML
    private ComboBox<Customer> destinationClient;

    @FXML
    private ComboBox<BankAccount> destinationAccount;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadBox1();
    }

    void loadBox1(){
        ObservableList<Customer> obsCust = FXCollections.observableList(user.customersOwned());
        sourceClient.setItems(obsCust);
    }

    @FXML
    void loadBox2(){
        List<Customer> customers = new ArrayList<>();
        Customer source = sourceClient.getSelectionModel().getSelectedItem();
        for(User user : Main.users){
            if(user.getType().equals("Cliente") && !(user.getName().equals(source.getName())) )
                customers.add((Customer) user);
        }
        ObservableList<Customer> obsCust = FXCollections.observableList(customers);
        destinationClient.setItems(obsCust);

        ObservableList<BankAccount> obsBank = FXCollections.observableList(source.getAccounts());
        sourceAccount.setItems(obsBank);
    }

    @FXML
    void loadBox3(){
        Customer destination = destinationClient.getSelectionModel().getSelectedItem();

        ObservableList<BankAccount> obsBank = FXCollections.observableList(destination.getAccounts());
        destinationAccount.setItems(obsBank);
    }

    @FXML
    void getValue(){
        transferAmount.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    transferAmount.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    void transferir(){
        Double valor = Double.parseDouble(transferAmount.getText());
        Alert alert = null;
        Stage stage = (Stage) transferButton.getScene().getWindow();
        accScr = sourceAccount.getSelectionModel().getSelectedItem();
        accDest = destinationAccount.getSelectionModel().getSelectedItem();
        if(accScr.testWithdraw(valor)){
            accDest.depositar(valor);
            alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sucesso");
            alert.setContentText("Operacao realizada con sucesso");
        }
        else{
            alert  = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro");
            alert.setContentText("Opercao cancelada, verifique seu saldo/limite");
        }
        alert.showAndWait();
        stage.close();
    }
}
