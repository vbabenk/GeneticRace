// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.mainMenu;

import GeneticRace.patientChooser.PatientChooserController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainMenuController {
    private PatientChooserController controller;
    @FXML
    private Label nameLabel;
    @FXML
    private Button addPatientBtn;
    @FXML
    private Button addConditionBtn;
    @FXML
    private Button fsPredBtn;
    @FXML
    private Button fsLookBtn;
    @FXML
    private Button ssPredBtn;
    @FXML
    private Button ssLookBtn;
    @FXML
    private Button logOutBtn;
    @FXML
    private Button exitBtn;

    public void initialize() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\realName.txt"));
        String currLine;
        while((currLine = reader.readLine()) != null){
            nameLabel.setText("Ласкаво просимо, " + currLine + "!");
        }
        reader.close();
        checkUserRole();
    }

    private String getUserRole() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\userRole.txt"));
        String currLine;
        String userRole = null;
        while((currLine = reader.readLine()) != null){
            userRole = currLine;
        }
        return userRole;
    }

    private void checkUserRole() throws IOException {
        if(getUserRole().equals("Admin")){
            addPatientBtn.setVisible(false);
            addConditionBtn.setVisible(false);
        }
    }

    public void addPatient() throws IOException {
        Stage stage = (Stage) addPatientBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/profile/ProfileView.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Анкета");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
        stage.show();
    }

    public void addCondition() throws IOException {
        Stage stage = (Stage) addConditionBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/patientChooser/PatientChooserView.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Список пацієнтів");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
        controller = loader.getController();
        controller.initData("Condition");
        stage.show();
    }

    public void predictFS() throws IOException {
        Stage stage = (Stage) fsPredBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/patientChooser/PatientChooserView.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Список пацієнтів");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
        controller = loader.getController();
        controller.initData("FSPrediction");
        stage.show();
    }

    public void lookFS() throws IOException {
        Stage stage = (Stage) fsLookBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/patientChooser/PatientChooserView.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Список пацієнтів");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
        controller = loader.getController();
        controller.initData("FSLook");
        stage.show();
    }

    public void predictSS() throws IOException {
        Stage stage = (Stage) ssPredBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/patientChooser/PatientChooserView.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Список пацієнтів");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
        controller = loader.getController();
        controller.initData("SSPrediction");
        stage.show();
    }

    public void lookSS() throws IOException {
        Stage stage = (Stage) ssLookBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/patientChooser/PatientChooserView.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Список пацієнтів");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
        controller = loader.getController();
        controller.initData("SSLook");
        stage.show();
    }

    public void logOut() throws IOException {
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/login/LoginView.fxml"));
        Parent root = loader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Авторизація в системі");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
        stage.show();
    }


    public void endProgram(){
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }
}
