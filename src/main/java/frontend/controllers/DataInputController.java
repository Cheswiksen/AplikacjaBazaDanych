package frontend.controllers;

import backend.entities.AnimalsEntity;
import backend.entities.DrugsEntity;
import backend.entities.UsersEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
    List<AnimalsEntity> animals;
    List<DrugsEntity> drugs;

    public DataInputController() {
    }

    @FXML
    public void OnStartAnimal() {
        AnimalComboBox.getItems().clear();
        animals = getAnimals();
        for (AnimalsEntity a : animals) {
            AnimalComboBox.getItems().add(a.getAnimalName());
        }

    }

    @FXML
    public void OnStartDrug1() {
        Drug1ComboBox.getItems().clear();
        drugs = getDrugs();
        for (DrugsEntity a : drugs) {
            Drug1ComboBox.getItems().add(a.getDrugName());
        }
    }

    @FXML
    public void OnStartDrug2() {
        Drug2ComboBox.getItems().clear();
        List<DrugsEntity> drugs = getDrugs();
        for (DrugsEntity a : drugs) {
            Drug2ComboBox.getItems().add(a.getDrugName());
        }
    }

    @FXML
    public void OnStartDrug3() {
        Drug3ComboBox.getItems().clear();
        List<DrugsEntity> drugs = getDrugs();
        for (DrugsEntity a : drugs) {
            Drug3ComboBox.getItems().add(a.getDrugName());
        }
    }

    // TODO: 22.01.2018 trzeba przefiltrowac te kolizje, tzn wyswietlic tylko te, ktore rowniez zostaly wybrane-
// TODO: 22.01.2018 backend wyrzuca wszystkie leki ktore koliduja z podanym
    @FXML
    public void CheckCollisionsAndDosages() {
        //drugscombobox zwraca ci stringa, bo wrzuciles do niego drugName
        //jezeli chcesz to zrobic w ten sposob musisz znalezc odpowiedni lek
        //a zamiast biegac forem po kolekcji mozna to zrobic lambdami, bo jest ladniej :P
        //co sie dzieje: filtruj z kolekcji e takie, ze drugName e jest rowny wartosci pobieranej z comboboxa
        //collect() decyduje o tym w jaki sposob zwrocic wyniki
        //a poniewaz jest tylko jeden taki obiekt, mozemy wyciagnac 1 z wynikowej kolekcji (czyli get(0))
        List kolizje = getCollisionData(drugs.stream().filter(
                e -> e.getDrugName().equals(Drug1ComboBox.getValue())
        ).collect(Collectors.toList()).get(0));
        //musisz jakos powyrzucac te kolizje ktorych nie chcemy :P

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
