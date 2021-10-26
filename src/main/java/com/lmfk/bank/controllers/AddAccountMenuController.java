package com.lmfk.bank.controllers;

import com.lmfk.bank.service.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AddAccountMenuController {
    private final Customer currentCust = (Customer) LoginController.user;

    @FXML
    public void newSimple(ActionEvent e) {
        currentCust.newAccount("simple");
        closeWindow(e);
    }

    @FXML
    public void newSaving(ActionEvent e) {
        currentCust.newAccount("savings");
        closeWindow(e);
    }

    @FXML
    public void newSpecial(ActionEvent e) {
        currentCust.newAccount("special");
        closeWindow(e);
    }

    void closeWindow(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
}
