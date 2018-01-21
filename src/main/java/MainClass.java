

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;

import static javafx.application.Application.launch;

public class MainClass extends Application {
    private Stage logowanie;
    private AnchorPane rootLayout;
    public Session session;

    public void start(Stage primaryStage) {
        this.logowanie = primaryStage;
        this.logowanie.setTitle("Logowanie");
        initRootLayout();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("Login.fxml"));
            rootLayout = loader.load();


            Scene scene = new Scene(rootLayout);
            logowanie.setScene(scene);
            logowanie.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public static void main(final String[] args) throws Exception {
        launch(args);
    }
}
