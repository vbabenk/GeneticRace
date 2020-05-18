// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.condition;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConditionController {
    private ConditionModel conditionModel;
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
    private ChoiceBox<String> peBox;
    @FXML
    private ChoiceBox<String> vabBox;
    @FXML
    private ChoiceBox<String> pEarlyBox;
    @FXML
    private ChoiceBox<String> plicatBox;
    @FXML
    private ChoiceBox<String> strokeBox;
    @FXML
    private ChoiceBox<String> thrombosisBox;
    @FXML
    private ChoiceBox<String> chyleBox;
    @FXML
    private ChoiceBox<String> avbBox;
    @FXML
    private ChoiceBox<String> sndBox;
    @FXML
    private Button backBtn;

    @FXML
    public void initialize() throws IOException, SQLException {
        conditionModel = new ConditionModel();
        ArrayList<String> patient = conditionModel.loadPatient();
        surnameField.setText(patient.get(0));
        firstnameField.setText(patient.get(1));
        middlenameField.setText(patient.get(2));
        sexField.setText(patient.get(3));
        birthdayField.setText(patient.get(4));
        ObservableList<String> yesNoList = FXCollections.observableArrayList("Ні", "Так");
        peBox.setItems(yesNoList);
        vabBox.setItems(yesNoList);
        pEarlyBox.setItems(yesNoList);
        plicatBox.setItems(yesNoList);
        strokeBox.setItems(yesNoList);
        thrombosisBox.setItems(yesNoList);
        chyleBox.setItems(yesNoList);
        avbBox.setItems(yesNoList);
        sndBox.setItems(yesNoList);
        peBox.getSelectionModel().selectFirst();
        vabBox.getSelectionModel().selectFirst();
        pEarlyBox.getSelectionModel().selectFirst();
        plicatBox.getSelectionModel().selectFirst();
        strokeBox.getSelectionModel().selectFirst();
        thrombosisBox.getSelectionModel().selectFirst();
        chyleBox.getSelectionModel().selectFirst();
        avbBox.getSelectionModel().selectFirst();
        sndBox.getSelectionModel().selectFirst();
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

    @FXML
    public void addToDatabase() throws SQLException, IOException {
        String pe = peBox.getValue();
        String vab = vabBox.getValue();
        String pEarly = pEarlyBox.getValue();
        String plicat = plicatBox.getValue();
        String stroke = strokeBox.getValue();
        String thrombosis = thrombosisBox.getValue();
        String chyle = chyleBox.getValue();
        String avb = avbBox.getValue();
        String snd = sndBox.getValue();
        boolean flag = conditionModel.addNewCondition(pe, vab, pEarly, plicat, stroke, thrombosis, chyle, avb, snd);
        if(!flag){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Увага");
            alert.setHeaderText("Даному пацієнту вже провели хірургічне лікування!");
            alert.setContentText("Досить з нього!");
            alert.showAndWait();
        }
    }
}
