package frontend.controllers;

import backend.entities.AnimalsEntity;
import backend.entities.UsersEntity;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javax.swing.table.TableColumn;

import java.util.List;

import static backend.utils.DataUtils.*;


public class DataInputController {
    private Mediator mediator;
    private UsersEntity user;
    @FXML
    TableColumn lek1Table;
    @FXML
    TableColumn Lek2Table;
    @FXML
    TableColumn TekstTable;
    @FXML
    TableColumn WarnTable;
    @FXML
    ComboBox AnimalComboBox;
    @FXML
    public void OnStart()
    {
        List<AnimalsEntity> zwierzaki = getAnimals();

        AnimalComboBox.getItems().addAll(zwierzaki);

    }


    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }



    public void getDrugs(Event event) {
    }

    public void CheckCollisionsAndDosages(ActionEvent actionEvent) {
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
