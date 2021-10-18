package com.lm.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AddAccountMenuController {
    private Customer currentCust = (Customer) LoginController.user;

    @FXML
    public void newSimple(ActionEvent e){
        currentCust.newAccount("simple");
        closeWindow(e);
    }

    @FXML
    public void newSaving(){
        currentCust.newAccount("savings");
    }

    @FXML
    public void newSpecial(){
        currentCust.newAccount("special");
    }

    void closeWindow(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
}
