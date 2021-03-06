// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.ssLook;

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
import java.util.ArrayList;


public class SSLookController {
    @FXML
    private TextField surnameField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField middlenameField;
    @FXML
    private TextField sexField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField x401Field;
    @FXML
    private TextField x402Field;
    @FXML
    private TextField x403Field;
    @FXML
    private TextField x404Field;
    @FXML
    private TextField x405Field;
    @FXML
    private TextField x406Field;
    @FXML
    private TextField x407Field;
    @FXML
    private TextField x408Field;
    @FXML
    private TextField x409Field;
    @FXML
    private TextField lastcommitField;
    @FXML
    private Button backBtn;

    @FXML
    public void initialize() throws IOException, SQLException {
        SSLookModel SSLookModel = new SSLookModel();
        ArrayList<String> patient = SSLookModel.loadPatient();
        if (patient.size() <= 5) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Увага");
            alert.setHeaderText("У даного пацієнта відсутнє спрогнозоване лікування!");
            alert.setContentText("Спробуйте пізніше!");
            alert.showAndWait();
        }
        else {
            surnameField.setText(patient.get(0));
            firstnameField.setText(patient.get(1));
            middlenameField.setText(patient.get(2));
            sexField.setText(patient.get(3));
            birthdayField.setText(patient.get(4));
            x401Field.setText(patient.get(5));
            x402Field.setText(patient.get(6));
            x403Field.setText(patient.get(7));
            x404Field.setText(patient.get(8));
            x405Field.setText(patient.get(9));
            x406Field.setText(patient.get(10));
            x407Field.setText(patient.get(11));
            x408Field.setText(patient.get(12));
            x409Field.setText(patient.get(13));
            lastcommitField.setText(patient.get(14));
        }
    }

    @FXML
    public void backToMenu() throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/mainMenu/MainMenuView.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Головне меню");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
        stage.show();
    }
}
