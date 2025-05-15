package py.com.honig.ibmsfx;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class SplashScreen {
    public static void show(Stage primaryStage, Runnable onFinish) {
        StackPane root = new StackPane();
        root.setPrefSize(620, 300);

        // Background image (from resources)
        BackgroundImage bgImage = new BackgroundImage(
                new Image(Objects.requireNonNull(SplashScreen.class.getResource("/py/com/honig/ibmsfx/splash.png")).toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false)
        );
        root.setBackground(new Background(bgImage));

        Scene scene = new Scene(root);

        // Configure the splash window
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setWidth(620);
        primaryStage.setHeight(300);
        primaryStage.centerOnScreen();
        primaryStage.show();

        // Delay and close splash
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {}
            Platform.runLater(() -> {
                primaryStage.close();
                onFinish.run();
            });
        }).start();
    }
}
