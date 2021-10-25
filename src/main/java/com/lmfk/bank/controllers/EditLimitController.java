package com.lmfk.bank.controllers;

import com.lmfk.bank.SpecialAccount;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditLimitController implements Initializable {
    private SpecialAccount current = (SpecialAccount) ManagerInfoUserController.userAcc;

    @FXML
    private Button okButton;

    @FXML
    private TextField value;

    @FXML
    private Label limite;

    @FXML
    void close() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        Double valor;
        if (value.getText().isEmpty())
            return;
        else {
            valor = Double.parseDouble(value.getText());
            current.setCredit(valor);
        }
        stage.close();
    }

    @FXML
    void getValue() {
        value.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    value.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        limite.setText("Limite da conta: " + current.getCredit());
    }
}
