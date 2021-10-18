package com.lm.bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static List<User> users = new ArrayList<>();
    public static User currentUser;

    @Override
    public void start(Stage stage) {
        try {
            users.add(new Manager("admin", "admin", "admin", "admin"));
            users.add(new Customer("customer1", "customer1", "Customer", "admin"));
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));
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
