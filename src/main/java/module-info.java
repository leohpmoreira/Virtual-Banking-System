module com.example.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.lmfk.bank to javafx.fxml;
    exports com.lmfk.bank;
    exports com.lmfk.bank.controllers;
    opens com.lmfk.bank.controllers to javafx.fxml;
}