package frontend.controllers;


import backend.entities.UsersEntity;
import backend.utils.BadPasswordException;
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
        } else register();
    }

    private void register() {
        String LoginName = LoginTextField.getText();
        String PasswordName = PasswordPasswordField.getText();
        user = null;
        try {
            user = LoginUtils.register(LoginName, PasswordName);
            if (user == null) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Taki użytkownik już istnieje!");
                alert.setHeaderText("ERROR");
                alert.setContentText("ERROR");
                alert.showAndWait();
            } else {
                mediator.showDataInput(user);
            }
        } catch (BadPasswordException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Taki użytkownik już istnieje!");
            alert.setHeaderText("ERROR");
            alert.setContentText("ERROR!");
            alert.showAndWait();
        }
    }

    @FXML
    public void GetIn() throws IOException {
        String LoginName = LoginTextField.getText();
        String PasswordName = PasswordPasswordField.getText();
        user = null;
        try {
            user = LoginUtils.login(LoginName, PasswordName);
            if (user == null) {
                throw new BadPasswordException();
            } else {
                mediator.showDataInput(user);
            }
        } catch (BadPasswordException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("ERROR!");
            alert.setHeaderText("ERROR");
            alert.setContentText("Złe hasło!");
            alert.showAndWait();
        }
    }


    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
