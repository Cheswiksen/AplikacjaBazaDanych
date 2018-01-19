package frontend.Controllers;


import backend.Entities.AnimalsEntity;
import backend.Entities.DrugsEntity;
import backend.Entities.UsersEntity;
import backend.Utils.LoginUtils;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sun.security.util.Password;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ShowData {

    @FXML
    private ComboBox AnimalComboBox;
    @FXML
    private ComboBox Drug1ComboBox;
    @FXML
    private ComboBox Drug2ComboBox;
    @FXML
    private ComboBox Drug3ComboBox;

    @FXML
    private void getAnimals()
    {
        //getAnimals from DataBase
    }

    @FXML
    private void getDrugs()
    {
        //getDrugs from DataBase
    }

    @FXML
    private void CheckCollisionsAndDosages()
    {
        //AnimalsEntity Animal = AnimalComboBox.getItems();

        //DrugsEntity Drug1 = Drug1ComboBox;

    }
}
