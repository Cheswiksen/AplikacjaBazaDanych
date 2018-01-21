package frontend.controllers;

import backend.entities.AnimalsEntity;
import backend.entities.DrugsEntity;
import backend.entities.UsersEntity;
import backend.utils.CollisionData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.table.TableColumn;

import java.util.List;
import java.util.Observable;

import static backend.utils.DataUtils.*;


public class DataInputController {
    private Mediator mediator;
    private UsersEntity user;

    @FXML
    private TableView<CollisionView> TableViewView;
    @FXML
    private javafx.scene.control.TableColumn<CollisionView, String> lek1;
    @FXML
    private javafx.scene.control.TableColumn<CollisionView, String> lek2;
    @FXML
    private javafx.scene.control.TableColumn<CollisionView, String> tekst;
    @FXML
    private javafx.scene.control.TableColumn<CollisionView, String> warn;
    @FXML
    ComboBox AnimalComboBox;
    @FXML
    ComboBox Drug1ComboBox;
    @FXML
    ComboBox Drug2ComboBox;
    @FXML
    ComboBox Drug3ComboBox;
    public ObservableList<CollisionView> list = FXCollections.observableArrayList();


    public DataInputController() {
    }

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
        //List<CollisionData> kolizje = getCollisionData((DrugsEntity) Drug1ComboBox.getValue());
        // To nie działa nie wiem dlaczego wróce potem


        lek1.setCellValueFactory(new PropertyValueFactory<CollisionView, String>("lek1"));
        lek2.setCellValueFactory(new PropertyValueFactory<CollisionView, String>("lek2"));
        tekst.setCellValueFactory(new PropertyValueFactory<CollisionView, String>("severity"));
        warn.setCellValueFactory(new PropertyValueFactory<CollisionView, String>("text"));

        TableViewView.setItems(list);
    }
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }





    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
