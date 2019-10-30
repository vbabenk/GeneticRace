package GeneticRace.patientChooser;

import GeneticRace.classes.Patient;
import GeneticRace.repositories.PatientRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientChooserController {
    private String variant;
    private String userRole;
    private ArrayList<Patient> patientList;
    @FXML
    private TableView<Patient> patientsTable;
    @FXML
    private TableColumn<ObservableList<Patient>, String> idColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> surnameColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> firstnameColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> middlenameColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> sexColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> birthdayColumn;
    @FXML
    private Button selectBtn;
    @FXML
    private Button backBtn;


    @FXML
    public void initialize() throws SQLException, IOException {
        PatientRepository patientRepository = new PatientRepository();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\userRole.txt"));
        String currLine;
        while ((currLine = reader.readLine()) != null) {
            userRole = currLine;
        }
        reader.close();
        patientList = patientRepository.getPatientList(userRole);
        addElementsToTable();
    }

    @FXML
    public void initData(String variant) {
        this.variant = variant;
    }

    private void addElementsToTable() {
        ObservableList<Patient> data = FXCollections.observableArrayList(patientList);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        middlenameColumn.setCellValueFactory(new PropertyValueFactory<>("middlename"));
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        patientsTable.setItems(data);
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
    public void choosePatient() throws IOException {
        Patient selectedPatient = patientsTable.getSelectionModel().getSelectedItem();
        try {
            String patientId = Integer.toString(selectedPatient.getId());
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\JavaProjects\\Babenko\\Files\\currentPatient.txt"));
            writer.write(patientId);
            writer.close();
            switch (variant) {
                case "Condition": {
                    Stage stage = (Stage) selectBtn.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/condition/ConditionView.fxml"));
                    Parent root = loader.load();
                    stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Додання післяопераційного стану пацієнта");
                    stage.setScene(new Scene(root));
                    stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
                    stage.show();
                    break;
                }
                case "FSPrediction": {
                    Stage stage = (Stage) selectBtn.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/firstStage/FirstStageView.fxml"));
                    Parent root = loader.load();
                    stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Прогнозування оперативного лікування");
                    stage.setScene(new Scene(root));
                    stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
                    stage.show();
                    break;
                }
                case "FSLook": {
                    Stage stage = (Stage) selectBtn.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/fsLook/FSLookView.fxml"));
                    Parent root = loader.load();
                    stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Перегляд оперативного лікування");
                    stage.setScene(new Scene(root));
                    stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
                    stage.show();
                    break;
                }
                case "SSPrediction": {
                    Stage stage = (Stage) selectBtn.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/secondStage/SecondStageView.fxml"));
                    Parent root = loader.load();
                    stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Прогнозування консервативного лікування");
                    stage.setScene(new Scene(root));
                    stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
                    stage.show();
                    break;
                }
                default: {
                    Stage stage = (Stage) selectBtn.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/ssLook/SSLookView.fxml"));
                    Parent root = loader.load();
                    stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Перегляд консервативного лікування");
                    stage.setScene(new Scene(root));
                    stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
                    stage.show();
                    break;
                }
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Увага");
            alert.setHeaderText("Виникла помилка!");
            alert.setContentText("Виберіть пацієнта, будь ласка!");
            alert.showAndWait();
        }
    }
}