package com.lm.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerMenuController {
    private FXMLLoader loader;
    private Scene scene;
    private Stage stage;

    @FXML
    void infoUser()throws IOException{
        loadScene(".fxml");
    }

    @FXML
    void infoConta()throws IOException{
        loadScene(".fxml");
    }

    @FXML
    void applyMoney()throws IOException{
        loadScene(".fxml");
    }

    @FXML
    void transfer()throws IOException{
        loadScene(".fxml");
    }

    @FXML
    void withdrawnFromAcc()throws IOException{
        loadScene(".fxml");
    }

    @FXML
    void editInfo()throws IOException{
        loadScene(".fxml");
    }

    @FXML
    void newUser()throws IOException{
        loadScene("/ManageNewUser.fxml");
    }

    @FXML
    void changePassword()throws IOException{
        loadScene("/UserChangePassword.fxml");
    }

    void loadScene(String path)throws IOException {
        loader = new FXMLLoader(getClass().getResource(path));
        stage = new Stage();
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

}
