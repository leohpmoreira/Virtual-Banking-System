package com.lm.bank;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerWithdrawnControler implements Initializable {
    private ObservableList<BankAccount> obsBankAcc;
    private Customer user = (Customer) Main.currentUser;
    private BankAccount currentAcc;

    @FXML
    private ComboBox<BankAccount> comboBox;

    @FXML
    private TextField value;

    @FXML
    private Label balance;

    @FXML
    private Button okButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCombobox();
    }

    @FXML
    public void getInfo(){
        currentAcc = comboBox.getSelectionModel().getSelectedItem();
        balance.setText("Saldo Atual: R$"+ currentAcc.getBalance());
        value.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    value.setText(newValue.replaceAll("[^\\d]",""));
                }
            }
        });
        okButton.setDisable(false);
    }

    void loadCombobox(){
        obsBankAcc = FXCollections.observableList(user.getAccounts());
        comboBox.setItems(obsBankAcc);
    }

    public void closeWithdrawn(){
        Stage stage = (Stage) okButton.getScene().getWindow();
        double valor;
        Alert alert;
        valor = Double.parseDouble(value.getText());
        if (currentAcc.withdraw(valor) == true){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sucesso");
            alert.setContentText("Operacao de Saque Realizada com sucesso");
        }
        else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro");
            alert.setContentText("Operacao de Saque negada, verifique seu saldo/limite disponivel");
        }
        alert.showAndWait();
        stage.close();
    }
}
