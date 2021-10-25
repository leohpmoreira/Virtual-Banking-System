package com.lmfk.bank.controllers;


import com.lmfk.bank.BankAccount;
import com.lmfk.bank.Customer;
import com.lmfk.bank.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManagerInfoUserController implements Initializable {
    private Manager current_user = (Manager) LoginController.user;
    public static BankAccount userAcc;

    @FXML
    private ComboBox<Customer> clientes;

    @FXML
    private Button okButton;

    @FXML
    private ComboBox<BankAccount> contas;

    @FXML
    void getClientes() throws IOException {
        loadConta();
    }


    @FXML
    void close() throws IOException {
        Stage atual = (Stage) okButton.getScene().getWindow();
        FXMLLoader loader = null;
        userAcc = contas.getSelectionModel().getSelectedItem();
        switch (userAcc.getType()) {
            case "Conta Poupança" -> loader = new FXMLLoader(ManagerInfoUserController.class.getResource("/Manager/EditInterest.fxml"));
            case "Conta Especial" -> loader = new FXMLLoader(ManagerInfoUserController.class.getResource("/Manager/EditLimit.fxml"));

        }
        if (loader != null) {
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
            atual.close();
        } else
            return;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadClientes();
    }

    void loadClientes() {
        ObservableList<Customer> obsClientes = FXCollections.observableList(current_user.customersOwned());
        clientes.setItems(obsClientes);
    }

    void loadConta() throws IOException {
        Customer client = clientes.getSelectionModel().getSelectedItem();
        List<BankAccount> cl_contas = new ArrayList<>();
        for (BankAccount account : client.getAccounts()) {
            if (account.getType().equals("Conta Poupança") || account.getType().equals("Conta Especial"))
                cl_contas.add(account);
        }
        if (contas != null) {
            ObservableList<BankAccount> obsContas = FXCollections.observableList(cl_contas);
            contas.setItems(obsContas);
        } else
            return;
    }
}
