package com.lmfk.bank;

import com.lmfk.bank.service.Encryption;
import com.lmfk.bank.service.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static List<User> users = new ArrayList<>();
    public static User currentUser;

    @Override
    public void start(Stage stage) {
        Encryption.loadUsers();
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Banco Virtual");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
