package frontend.controllers;

import backend.entities.UsersEntity;
import backend.utils.LoginUtils;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import static java.lang.System.*;

public class Login {
    @FXML
    private TextField LoginTextField;
    @FXML
    private PasswordField PasswordPasswordField;
    @FXML
    public void LoginPressed() {

        if (LoginTextField.getText().isEmpty() || PasswordPasswordField.getText().isEmpty()) {
            //warning Podaj login/hasło
            out.println("NOT ok");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Brak danych logowania");
            alert.setHeaderText("Nie wpisano potrzebnych danych");
            alert.setContentText("Podaj dane logowania");
            alert.showAndWait();

        } else {
            String LoginName = LoginTextField.getText();
            String PasswordName = PasswordPasswordField.getText();
            UsersEntity user = LoginUtils.login(LoginName, PasswordName);
            out.println("ok");
        }


    }

    @FXML
    public void RegisterPressed() {
        if (LoginTextField.getText().isEmpty() || PasswordPasswordField.getText().isEmpty()) {
            //warning Podaj login/hasło
            out.println("NOT ok");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Brak danych rejestracji");
            alert.setHeaderText("Nie wpisano potrzebnych danych");
            alert.setContentText("Podaj dane rejestracji");

            alert.showAndWait();

        } else {
            String LoginName = LoginTextField.getText();
            String PasswordName = PasswordPasswordField.getText();
            UsersEntity user = backend.utils.LoginUtils.register(LoginName, PasswordName);
            out.println("ok");
        }
    }

}
