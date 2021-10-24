package com.lm.bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static javafx.application.Application.launch;

public class Main extends Application {
    public static List<User> users = new ArrayList<>();
    public static User currentUser;

    void loadUsers(){
        String[] dados;
        String username,password,type,manager;
        File arquivo = new File("users.txt");
        try{
            if(!arquivo.exists()){
                arquivo.createNewFile();
            }

            BufferedReader dataR = new BufferedReader(new FileReader(arquivo));
            while(dataR.ready()){
                dados = dataR.readLine().split("-");
                System.out.printf("%s %s %s %s",dados[0],dados[1],dados[2],dados[3]);
                switch(dados[2]){
                    case "Gerente" -> users.add(new Manager(dados[0],dados[1],dados[2],dados[3]));
                    case "Cliente" -> users.add(new Customer(dados[0],dados[1],dados[2],dados[3]));
                }
            }
            dataR.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) {
        loadUsers();
        try {
            users.add(new Manager("admin", "admin", "Gerente", "admin"));
            users.add(new Customer("customer1", "customer1", "Cliente", "admin"));
            Parent root = FXMLLoader.load(Main.class.getResource("/Test/Login.fxml"));
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
