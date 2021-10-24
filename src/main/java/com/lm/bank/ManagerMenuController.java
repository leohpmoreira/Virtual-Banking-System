package com.lm.bank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerMenuController {
    private FXMLLoader loader;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button sair;

    @FXML
    void infoUser()throws IOException{
        loadScene("/InfoUser.fxml");
    }

    @FXML
    void infoConta()throws IOException{
        loadScene("/infoConta.fxml");
    }

    @FXML
    void applyMoney()throws IOException{
        loadScene("/ApplyMoney.fxml");
    }

    @FXML
    void transfer()throws IOException{
        loadScene(".fxml");
    }

    @FXML
    void withdrawnFromAcc()throws IOException{
        loadScene("/ManagerWithdrawn.fxml");
    }

    @FXML
    void editInfo()throws IOException{
        loadScene("/ManagerInfoUser.fxml");
    }

    @FXML
    void newUser()throws IOException{
        loadScene("/ManagerNewUser.fxml");
    }

    @FXML
    void changePassword()throws IOException{
        loadScene("/UserChangePassword.fxml");
    }

    @FXML
    void sair() throws IOException{
        Stage atual = (Stage) sair.getScene().getWindow();
        loader = new FXMLLoader(getClass().getResource("/Test/Login.fxml"));
        stage = new Stage();
        scene = new Scene(loader.load());
        stage.setScene(scene);
        atual.close();
        stage.show();
    }

    void loadScene(String path)throws IOException {
        loader = new FXMLLoader(getClass().getResource(path));
        stage = new Stage();
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

}
