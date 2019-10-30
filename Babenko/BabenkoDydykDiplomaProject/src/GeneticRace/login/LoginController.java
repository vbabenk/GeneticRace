package GeneticRace.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    private LoginModel loginModel;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginBtn;

    @FXML
    public void initialize() {
        loginModel = new LoginModel();
    }

    @FXML
    public void logIn() throws IOException, SQLException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean flag = loginModel.checkAccount(username, password);
        if (flag) {
            loginModel.writeAccount(username, password);
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/mainMenu/MainMenuView.fxml"));
            Parent root = loader.load();
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Головне меню");
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Увага");
            alert.setHeaderText("Виникла помилка!");
            alert.setContentText("Логін або пароль введені неправильно, спробуйте ще раз");
            alert.showAndWait();
        }
    }
}
