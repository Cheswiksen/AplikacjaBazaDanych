package frontend.controllers;

import backend.entities.AnimalsEntity;
import backend.entities.DrugsEntity;
import backend.entities.UsersEntity;
import backend.utils.CollisionData;
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
    ComboBox Drug1ComboBox;
    @FXML
    ComboBox Drug2ComboBox;
    @FXML
    ComboBox Drug3ComboBox;
    @FXML
    public void OnStartAnimal()
    {
        AnimalComboBox.getItems().clear();
        List<AnimalsEntity> zwierzaki = getAnimals();
        for (AnimalsEntity a : zwierzaki)
        {
            AnimalComboBox.getItems().add(a.getAnimalName());
        }

    }
    @FXML
    public void OnStartDrug1()
    {
        Drug1ComboBox.getItems().clear();
        List<DrugsEntity> drugs = getDrugs();
        for (DrugsEntity a : drugs)
        {
            Drug1ComboBox.getItems().add(a.getDrugName());
        }
    }
    @FXML
    public void OnStartDrug2()
    {
        Drug2ComboBox.getItems().clear();
        List<DrugsEntity> drugs = getDrugs();
        for (DrugsEntity a : drugs)
        {
            Drug2ComboBox.getItems().add(a.getDrugName());
        }
    }
    @FXML
    public void OnStartDrug3()
    {
        Drug3ComboBox.getItems().clear();
        List<DrugsEntity> drugs = getDrugs();
        for (DrugsEntity a : drugs)
        {
            Drug3ComboBox.getItems().add(a.getDrugName());
        }
    }

    @FXML
    public void CheckCollisionsAndDosages()
    {

    }
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }





    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
