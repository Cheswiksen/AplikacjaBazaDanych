package frontend.controllers;

import backend.entities.UsersEntity;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javax.swing.table.TableColumn;

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


    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void getAnimals(Event event) {
    }

    public void getDrugs(Event event) {
    }

    public void CheckCollisionsAndDosages(ActionEvent actionEvent) {
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
