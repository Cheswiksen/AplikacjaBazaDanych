package frontend.controllers;

import backend.entities.AnimalsEntity;
import backend.entities.DrugsEntity;
import backend.entities.UsersEntity;
import backend.utils.CollisionData;
import backend.utils.DataUtils;
import backend.utils.DosageData;
import frontend.utils.CollisionView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

import static backend.utils.DataUtils.getAnimals;
import static backend.utils.DataUtils.getDrugs;


@SuppressWarnings("ALL")
public class DataInputController {
    @FXML
    public TableView dosageTableView;
    @FXML
    public TableColumn drugDosageCol;
    @FXML
    public TableColumn minValueCol;
    @FXML
    public TableColumn maxValueCol;
    @FXML
    public TableColumn unitCol;
    @FXML
    public TableColumn methodCol;
    @FXML
    public TableColumn commentCol1;
    @FXML
    private TableView<CollisionView> collisionTableView;
    @FXML
    private TableColumn<CollisionView, String> drug1Col;
    @FXML
    private TableColumn<CollisionView, String> drug2Col;
    @FXML
    private TableColumn<CollisionView, String> textCol;
    @FXML
    private TableColumn<CollisionView, String> warnCol;
    @FXML
    ComboBox animalComboBox;
    @FXML
    ComboBox drug1ComboBox;
    @FXML
    ComboBox drug2ComboBox;
    @FXML
    ComboBox drug3ComboBox;
    private List<AnimalsEntity> animals;
    private List<DrugsEntity> drugs;
    private Mediator mediator;
    private UsersEntity user;

    @FXML
    public void initialize() {
        animals = getAnimals();
        drugs = getDrugs();
        initAnimals();
        initDrugs();
        initCollisions();
        initDosages();
        animalComboBox.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            updateDosages();
        }
        ));
        drug1ComboBox.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            checkCollisions();
            updateDosages();
        }
        ));
        drug2ComboBox.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            checkCollisions();
            updateDosages();
        }));
        drug3ComboBox.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            checkCollisions();
            updateDosages();
        }));
    }

    private void initDosages() {
        drugDosageCol.setCellValueFactory(new PropertyValueFactory<>("drug"));
        minValueCol.setCellValueFactory(new PropertyValueFactory<>("min"));
        maxValueCol.setCellValueFactory(new PropertyValueFactory<>("max"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        methodCol.setCellValueFactory(new PropertyValueFactory<>("method"));
        commentCol1.setCellValueFactory(new PropertyValueFactory<>("comment"));

    }

    private void initAnimals() {
        drugs = getDrugs();
        Callback<ListView<AnimalsEntity>, ListCell<AnimalsEntity>> cellFactory = lv -> new ListCell<AnimalsEntity>() {
            @Override
            protected void updateItem(AnimalsEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getAnimalName());
            }
        };
        animalComboBox.setCellFactory(cellFactory);
        animalComboBox.setButtonCell(cellFactory.call(null));
        animalComboBox.setItems(FXCollections.observableArrayList(animals));
    }

    private void updateDosages() {
        AnimalsEntity animal = (AnimalsEntity) animalComboBox.getValue();
        DrugsEntity d1 = (DrugsEntity) drug1ComboBox.getValue();
        DrugsEntity d2 = (DrugsEntity) drug2ComboBox.getValue();
        DrugsEntity d3 = (DrugsEntity) drug3ComboBox.getValue();
        List<DosageData> dosageData = DataUtils.getDosageData(animal, d1);
        dosageData.addAll(DataUtils.getDosageData(animal, d2));
        dosageData.addAll(DataUtils.getDosageData(animal, d3));
        dosageTableView.setItems(FXCollections.observableArrayList(dosageData));
    }

    private void initCollisions() {
        drug1Col.setCellValueFactory(new PropertyValueFactory<>("drug1"));
        drug2Col.setCellValueFactory(new PropertyValueFactory<>("drug2"));
        textCol.setCellValueFactory(new PropertyValueFactory<>("text"));
        warnCol.setCellValueFactory(new PropertyValueFactory<>("severity"));
    }

    private void checkCollisions() {
        DrugsEntity d1 = (DrugsEntity) drug1ComboBox.getValue();
        DrugsEntity d2 = (DrugsEntity) drug2ComboBox.getValue();
        DrugsEntity d3 = (DrugsEntity) drug3ComboBox.getValue();
        List<CollisionView> collisionViews = new ArrayList<>();
        collisionViews.addAll(getCollisionView(d1, d2));
        collisionViews.addAll(getCollisionView(d1, d3));
        collisionViews.addAll(getCollisionView(d2, d3));

        ObservableList<CollisionView> obsCollisionView = FXCollections.observableArrayList(collisionViews);
        collisionTableView.setItems(obsCollisionView);
    }

    private List<CollisionView> getCollisionView(DrugsEntity d1, DrugsEntity d2) {
        if (d1 == null || d2 == null)
            return new ArrayList<>();
        List<CollisionData> cols = DataUtils.getCollisionData(d1);
        List<CollisionData> filteredCols = new ArrayList<>();
        for (CollisionData cd : cols) {
            if (cd.drugName.equals(d2.getDrugName())) {
                filteredCols.add(cd);
            }
        }
        List<CollisionView> results = new ArrayList<>();
        for (CollisionData cd : filteredCols) {
            results.add(new CollisionView(d1.getDrugName(), cd.drugName, cd.collisionSeverity, cd.collisionText));
        }
        return results;
    }

    public void initDrugs() {
        drugs = getDrugs();
        Callback<ListView<DrugsEntity>, ListCell<DrugsEntity>> cellFactory = lv -> new ListCell<DrugsEntity>() {
            @Override
            protected void updateItem(DrugsEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getDrugName());
            }

        };
        drug1ComboBox.setCellFactory(cellFactory);
        drug1ComboBox.setButtonCell(cellFactory.call(null));
        drug1ComboBox.setItems(FXCollections.observableArrayList(drugs));
        drug2ComboBox.setCellFactory(cellFactory);
        drug2ComboBox.setButtonCell(cellFactory.call(null));
        drug2ComboBox.setItems(FXCollections.observableArrayList(drugs));
        drug3ComboBox.setCellFactory(cellFactory);
        drug3ComboBox.setButtonCell(cellFactory.call(null));
        drug3ComboBox.setItems(FXCollections.observableArrayList(drugs));
    }


    @FXML
    public void GoToDosages() {
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
