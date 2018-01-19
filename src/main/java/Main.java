import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    private Stage logowanie;
    private AnchorPane rootLayout;
//    private static final SessionFactory sf;
//    static {
//        try {
//            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//    private static Session getSession() throws HibernateException {
//        return sf.openSession();
//    }


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
        /*String password = "dupa1234";
        String salt = LoginUtils.GetSalt();
        String hashedPassword = LoginUtils.hashPwd(password, salt);
        System.out.println("sol:" + salt);
        System.out.println("zahashowane haslo: " + hashedPassword);

        try (Session session = getSession()) {
            session.beginTransaction();
            List<AnimalsEntity> result=session.createQuery("from AnimalsEntity").list();
            for(AnimalsEntity a:result){
                System.out.println(a.toString());
            }
        }*/
        launch(args);
    }
}
