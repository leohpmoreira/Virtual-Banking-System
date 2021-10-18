package com.lm.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerMenuController{
    @FXML
    protected void goAddAccount(ActionEvent e) throws IOException{
        loadScene("/AddAccountMenu.fxml");
    }

    @FXML
    protected void goDeposito() throws IOException{
        loadScene("/CustomerDeposit.fxml");
    }
    @FXML
    protected void goSacar()throws IOException{
        loadScene("/CustomerWithdrawn.fxml");
    }
    @FXML
    protected void goSaldo() throws IOException {
        loadScene("/CustomerBalance.fxml");
    }

    @FXML
    protected void goExtrato() throws IOException{
        loadScene("/CustomerBankStatement.fxml");
    }
    @FXML
    protected void goAlteraSenha(){

    }

    private void loadScene(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.showAndWait();
    }
}
