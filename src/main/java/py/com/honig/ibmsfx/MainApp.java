package py.com.honig.ibmsfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
    private static Stage mainStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        SplashScreen.show(stage, () -> showLoginWindow());
    }

    public static void showLoginWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/py/com/honig/ibmsfx/LoginView.fxml"));
            Pane root = loader.load();
            Scene scene = new Scene(root);
            Stage loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.setTitle("Login");
            loginStage.setWidth(300);
            loginStage.setHeight(250);
            loginStage.setResizable(false);
            loginStage.centerOnScreen();
            loginStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showMainWindow() {
        try {
            mainStage = new Stage();
            Pane root = new Pane(); // Replace with your actual FXML
            Scene scene = new Scene(root, 800, 600);
            mainStage.setScene(scene);
            mainStage.setTitle("Main Menu");
            mainStage.setMaximized(true);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
