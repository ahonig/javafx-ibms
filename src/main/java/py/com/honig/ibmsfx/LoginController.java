package py.com.honig.ibmsfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    protected void onCancel() {
        System.exit(0);
    }

    @FXML
    protected void onLogin() {
        String user = usernameField.getText();
        String pass = passwordField.getText();
        if (user.isEmpty() || pass.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Username and password cannot be empty.").showAndWait();
            return;
        }

        // Later: validate with DB
        MainApp.showMainWindow(); // After successful login
        ((Stage) usernameField.getScene().getWindow()).close(); // Close login
    }
}
