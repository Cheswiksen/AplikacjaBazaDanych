import java.io.IOException;
import java.util.List;

import backend.Entities.AnimalsEntity;
import backend.Entities.UsersEntity;
import backend.Utils.LoginUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static backend.Utils.Connections.getSession;
import static javafx.application.Application.launch;

public class Main extends Application {
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
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Login.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            logowanie.setScene(scene);
            logowanie.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(final String[] args) throws Exception {
        LoginUtils.login("user","user");
        launch(args);
    }
}
