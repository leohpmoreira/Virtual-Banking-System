package com.lmfk.bank;

import com.lmfk.bank.controllers.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserChangePasswordMenu {
    private User current = LoginController.user;

    @FXML
    private TextField oldPassword;

    @FXML
    private PasswordField newPassword;

    @FXML
    private Button change;

    @FXML
    void close() {
        Stage stage = (Stage) change.getScene().getWindow();
        Alert alert;
        String velha = oldPassword.getText();
        String nova = newPassword.getText();
        if (current.getPassword().equals(velha)) {
            current.setPassword(nova);
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sucesso");
            alert.setContentText("Senha alterada com sucesso");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro");
            alert.setContentText("Senha antiga invalida");
        }
        alert.showAndWait();
        stage.close();
    }
}
