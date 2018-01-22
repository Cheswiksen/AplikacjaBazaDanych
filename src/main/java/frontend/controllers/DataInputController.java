package frontend.controllers;

import backend.entities.AnimalsEntity;
import backend.entities.DrugsEntity;
import backend.entities.UsersEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Collectors;

import static backend.utils.DataUtils.*;


public class DataInputController {
    private Mediator mediator;
    private UsersEntity user;

    @FXML
    private TableView<CollisionView> TableViewView;
    @FXML
    private TableColumn<CollisionView, String> lek1;
    @FXML
    private TableColumn<CollisionView, String> lek2;
    @FXML
    private TableColumn<CollisionView, String> tekst;
    @FXML
    private TableColumn<CollisionView, String> warn;
    @FXML
    ComboBox AnimalComboBox;
    @FXML
    ComboBox Drug1ComboBox;
    @FXML
    ComboBox Drug2ComboBox;
    @FXML
    ComboBox Drug3ComboBox;
    public ObservableList<CollisionView> list = FXCollections.observableArrayList();
    List<AnimalsEntity> animals;
    List<DrugsEntity> drugs;

    public DataInputController() {

    }

    @FXML
    public void initialize() {
        Drug1ComboBox.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) ->
        {
            checkCollisions((DrugsEntity) newValue);
        }));
        animals = getAnimals();
        drugs = getDrugs();
        initDrugs();
    }

    private void checkCollisions(DrugsEntity newValue) {
    }

    public void initDrugs() {
        drugs = getDrugs();
        for (DrugsEntity a : drugs) {
            Drug1ComboBox.getItems().add(a.getDrugName());
            Drug2ComboBox.getItems().add(a.getDrugName());
            Drug3ComboBox.getItems().add(a.getDrugName());
        }
    }


    // TODO: 22.01.2018 trzeba przefiltrowac te kolizje, tzn wyswietlic tylko te, ktore rowniez zostaly wybrane-
// TODO: 22.01.2018 backend wyrzuca wszystkie leki ktore koliduja z podanym
    @FXML
    public void GoToDosages() {
        List kolizje = getCollisionData(drugs.stream().filter(
                e -> e.getDrugName().equals(Drug1ComboBox.getValue())
        ).collect(Collectors.toList()).get(0));
        ObservableList observableKolizje = FXCollections.observableArrayList(kolizje);
        lek1.setCellValueFactory(new PropertyValueFactory<CollisionView, String>("drugName"));
        lek2.setCellValueFactory(new PropertyValueFactory<CollisionView, String>("drugName"));
        tekst.setCellValueFactory(new PropertyValueFactory<CollisionView, String>("collisionSeverity"));
        warn.setCellValueFactory(new PropertyValueFactory<CollisionView, String>("collisionText"));
        TableViewView.setItems(observableKolizje);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
