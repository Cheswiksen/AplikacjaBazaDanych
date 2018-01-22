package frontend.main;

import frontend.controllers.DataInputController;
import frontend.controllers.LoginController;
import frontend.controllers.Mediator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {
    private Stage mainWindow;
    private Scene loginScene;
    private LoginController loginController;
    private Scene dataInputScene;
    private DataInputController dataInputController;
    private Mediator mediator;

    public void start(Stage primaryStage) {
        this.mainWindow = primaryStage;
        this.mainWindow.setTitle("Logowanie");
        initLoginLayout();
        initDataInputLayout();
        mediator = new Mediator(this, loginController, dataInputController);
        showLogin();
    }

    private void showLogin() {
        mainWindow.setScene(loginScene);
        mainWindow.show();
    }

    public void showDataInput() {
        mainWindow.setScene(dataInputScene);
        mainWindow.show();
    }

    public void initLoginLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("/LoginView.fxml"));
            AnchorPane rootLayout = loader.load();
            loginScene = new Scene(rootLayout);
            loginController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initDataInputLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            String Url;
            Url = "/DataInputView.fxml";
            loader.setLocation(MainClass.class.getResource(Url));
            AnchorPane showDataLayout = loader.load();
            dataInputScene = new Scene(showDataLayout);
            dataInputController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(final String[] args) throws Exception {
        launch(args);
    }
}
