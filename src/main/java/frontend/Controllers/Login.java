package frontend.Controllers;


import backend.Entities.UsersEntity;
import backend.Utils.LoginUtils;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sun.security.util.Password;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import static java.lang.System.*;


public class Login {
    @FXML
    private TextField LoginTextField;
    @FXML
    private PasswordField PasswordPasswordField;

    @FXML
    public void LoginPressed()
    {

        if(LoginTextField.getText().isEmpty() || PasswordPasswordField.getText().isEmpty())
        {
            //warning Podaj login/hasło
            out.println("NOT ok");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Brak danych logowania");
            alert.setHeaderText("Nie wpisano potrzebnych danych");
            alert.setContentText("Podaj dane logowania");

            alert.showAndWait();

        }
        else {
            String LoginName = LoginTextField.getText();
            String PasswordName = PasswordPasswordField.getText();
            UsersEntity user= LoginUtils.Login(LoginName, PasswordName);
            out.println("ok");
        }


    }
}
