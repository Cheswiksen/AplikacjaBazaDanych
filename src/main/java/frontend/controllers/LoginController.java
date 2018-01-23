package frontend.controllers;


import backend.entities.UsersEntity;
import backend.utils.LoginUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static java.lang.System.out;


public class LoginController {
    private AnchorPane rootLayout;
    private Mediator mediator;

    @FXML
    Button LoginPressed;
    @FXML
    UsersEntity user;
    @FXML
    private TextField LoginTextField;
    @FXML
    private PasswordField PasswordPasswordField;

    @FXML
    public void LoginPressed() throws IOException {

        if (LoginTextField.getText().isEmpty() || PasswordPasswordField.getText().isEmpty()) {

            //warning Podaj login/hasło
            out.println("NOT ok");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Brak danych logowania");
            alert.setHeaderText("Nie wpisano potrzebnych danych");
            alert.setContentText("Podaj dane logowania");
            alert.showAndWait();
        } else {
            GetIn();
        }
    }

    @FXML
    public void RegisterPressed() throws IOException {

        if (LoginTextField.getText().isEmpty() || PasswordPasswordField.getText().isEmpty()) {
            //warning Podaj login/hasło
            out.println("NOT ok");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Brak danych rejestracji");
            alert.setHeaderText("Nie wpisano potrzebnych danych");
            alert.setContentText("Podaj dane rejestracji");
            alert.showAndWait();

        } else
        {
            String LoginName = LoginTextField.getText();
            String PasswordName = PasswordPasswordField.getText();
            UsersEntity user = LoginUtils.register(LoginName, PasswordName);
            GetIn();
        }
    }

    @FXML
    public void GetIn() throws IOException {
        String LoginName = LoginTextField.getText();
        String PasswordName = PasswordPasswordField.getText();
        user = null;
        user = LoginUtils.login(LoginName, PasswordName);

        if (user == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Zle dane");
            alert.setHeaderText("Nie wpisano poprawnych danych");
            alert.setContentText("Podaj poprawne dane logowania");
            alert.showAndWait();
        } else {
            mediator.showDataInput(user);
            out.println("ok");
        }
    }


    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
