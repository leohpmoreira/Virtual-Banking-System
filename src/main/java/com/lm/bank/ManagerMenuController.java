package com.lm.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerMenuController {
    private FXMLLoader loader;
    private Scene scene;
    private Stage stage;

    @FXML
    void infoUser(){
        loadScene(".fxml");
    }

    @FXML
    void infoConta(){
        loadScene(".fxml");
    }

    @FXML
    void applyMoney(){
        loadScene(".fxml");
    }

    @FXML
    void transfer(){
        loadScene(".fxml");
    }

    @FXML
    void withdrawnFromAcc(){
        loadScene(".fxml");
    }

    @FXML
    void editInfo(){
        loadScene(".fxml");
    }

    @FXML
    void newUser(){
        loadScene("ManageNewUser.fxml");
    }

    @FXML
    void changePassword(){
        loadScene("CustomerChangePassword.fxml");
    }

    void loadScene(String path){
        try {
            loader = new FXMLLoader(getClass().getResource(path));
            stage = new Stage();
            scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
