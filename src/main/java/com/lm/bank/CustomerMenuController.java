package com.lm.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerMenuController {
    @FXML
    protected void goAddAccount() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddAccountMenu.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void goDeposito(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CustomerDeposit.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void goSacar(){

    }
    @FXML
    protected void goSaldo(){

    }
    @FXML
    protected void goExtrato(){

    }
    @FXML
    protected void goAlteraSenha(){

    }
}
