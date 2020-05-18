// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.secondStage;

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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SecondStageController {
    private SecondStageModel ssModel;
    private ArrayList<String> patient;
    private ArrayList<String> resultList;
    private String userRole;
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
    private TextField peField;
    @FXML
    private TextField vabField;
    @FXML
    private TextField pEarlyField;
    @FXML
    private TextField plicatField;
    @FXML
    private TextField strokeField;
    @FXML
    private TextField thrombosisField;
    @FXML
    private TextField chyleField;
    @FXML
    private TextField avbField;
    @FXML
    private TextField sndField;
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
    private TextField x501Field;
    @FXML
    private TextField x502Field;
    @FXML
    private TextField x503Field;
    @FXML
    private TextField x504Field;
    @FXML
    private TextField x505Field;
    @FXML
    private TextField x506Field;
    @FXML
    private TextField x507Field;
    @FXML
    private TextField x508Field;
    @FXML
    private TextField x509Field;
    @FXML
    private Button predictBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Button addBtn;


    @FXML
    public void initialize() throws SQLException, IOException {
        ssModel = new SecondStageModel();
        patient = ssModel.loadPatient();
        if (patient.size() <= 5) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Увага");
            alert.setHeaderText("Даному пацієнту ще не провели хірургічне лікування!");
            alert.setContentText("Спробуйте пізніше!");
            alert.showAndWait();
            predictBtn.setDisable(true);
        } else {
            surnameField.setText(patient.get(0));
            firstnameField.setText(patient.get(1));
            middlenameField.setText(patient.get(2));
            sexField.setText(patient.get(3));
            birthdayField.setText(patient.get(4));
            peField.setText(patient.get(5));
            vabField.setText(patient.get(6));
            pEarlyField.setText(patient.get(7));
            plicatField.setText(patient.get(8));
            strokeField.setText(patient.get(9));
            thrombosisField.setText(patient.get(10));
            chyleField.setText(patient.get(11));
            avbField.setText(patient.get(12));
            sndField.setText(patient.get(13));
            BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\userRole.txt"));
            String currLine;
            while ((currLine = reader.readLine()) != null) {
                userRole = currLine;
            }
            reader.close();
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

    @FXML
    public void calculateTreatment() throws IOException, InterruptedException {
        resultList = ssModel.calculateTreatment(patient);
        x401Field.setText(resultList.get(0));
        x402Field.setText(resultList.get(1));
        x403Field.setText(resultList.get(2));
        x404Field.setText(resultList.get(3));
        switch (resultList.get(4)) {
            case "1":
                x405Field.setText("Ні");
                break;
            case "2":
                x405Field.setText("В перший день");
                break;
            case "3":
                x405Field.setText("В другий день");
                break;
            case "4":
                x405Field.setText("В третій день");
                break;
            case "5":
                x405Field.setText("В четвертий день");
                break;
            case "6":
                x405Field.setText("В пятий день");
                break;
            default:
                x405Field.setText("В шостий день");
                break;
        }
        switch (resultList.get(5)) {
            case "1":
                x406Field.setText("Ні");
                break;
            case "2":
                x406Field.setText("В перший день");
                break;
            case "3":
                x406Field.setText("В другий день");
                break;
            default:
                x406Field.setText("В третій день");
                break;
        }
        switch (resultList.get(6)) {
            case "1":
                x407Field.setText("Ні");
                break;
            case "2":
                x407Field.setText("Дексон");
                break;
            default:
                x407Field.setText("Преднізолон");
                break;
        }
        if (resultList.get(7).equals("1")) {
            x408Field.setText("Так");
        } else {
            x408Field.setText("Ні");
        }
        if (resultList.get(8).equals("1")) {
            x409Field.setText("Так");
        } else {
            x409Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x501Field.setText("Ні");
        } else {
            x501Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x502Field.setText("Ні");
        } else {
            x502Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x503Field.setText("Ні");
        } else {
            x503Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x504Field.setText("Ні");
        } else {
            x504Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x505Field.setText("Ні");
        } else {
            x505Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x506Field.setText("Ні");
        } else {
            x506Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x507Field.setText("Ні");
        } else {
            x507Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x508Field.setText("Ні");
        } else {
            x508Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x509Field.setText("Ні");
        } else {
            x509Field.setText("Так");
        }
        predictBtn.setDisable(true);
        if(userRole.equals("Doctor")){
            addBtn.setDisable(false);
        }
    }

    @FXML
    public void addToDatabase() throws IOException, SQLException {
        ArrayList<String> resultList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\currentPatient.txt"));
        String currLine;
        String id = null;
        while ((currLine = reader.readLine()) != null) {
            id = currLine;
        }
        reader.close();
        resultList.add(id);
        resultList.add(x401Field.getText());
        resultList.add(x402Field.getText());
        resultList.add(x403Field.getText());
        resultList.add(x404Field.getText());
        resultList.add(x405Field.getText());
        resultList.add(x406Field.getText());
        resultList.add(x407Field.getText());
        resultList.add(x408Field.getText());
        resultList.add(x409Field.getText());
        ssModel.saveResult(resultList);
    }

    @FXML
    public void variant1() {
        x401Field.setText(resultList.get(0));
        x402Field.setText(resultList.get(1));
        x403Field.setText(resultList.get(2));
        x404Field.setText(resultList.get(3));
        switch (resultList.get(4)) {
            case "1":
                x405Field.setText("Ні");
                break;
            case "2":
                x405Field.setText("В перший день");
                break;
            case "3":
                x405Field.setText("В другий день");
                break;
            case "4":
                x405Field.setText("В третій день");
                break;
            case "5":
                x405Field.setText("В четвертий день");
                break;
            case "6":
                x405Field.setText("В пятий день");
                break;
            default:
                x405Field.setText("В шостий день");
                break;
        }
        switch (resultList.get(5)) {
            case "1":
                x406Field.setText("Ні");
                break;
            case "2":
                x406Field.setText("В перший день");
                break;
            case "3":
                x406Field.setText("В другий день");
                break;
            default:
                x406Field.setText("В третій день");
                break;
        }
        switch (resultList.get(6)) {
            case "1":
                x407Field.setText("Ні");
                break;
            case "2":
                x407Field.setText("Дексон");
                break;
            default:
                x407Field.setText("Преднізолон");
                break;
        }
        if (resultList.get(7).equals("1")) {
            x408Field.setText("Так");
        } else {
            x408Field.setText("Ні");
        }
        if (resultList.get(8).equals("1")) {
            x409Field.setText("Так");
        } else {
            x409Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x501Field.setText("Ні");
        } else {
            x501Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x502Field.setText("Ні");
        } else {
            x502Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x503Field.setText("Ні");
        } else {
            x503Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x504Field.setText("Ні");
        } else {
            x504Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x505Field.setText("Ні");
        } else {
            x505Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x506Field.setText("Ні");
        } else {
            x506Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x507Field.setText("Ні");
        } else {
            x507Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x508Field.setText("Ні");
        } else {
            x508Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x509Field.setText("Ні");
        } else {
            x509Field.setText("Так");
        }
    }

    @FXML
    public void variant2() {
        x401Field.setText(resultList.get(9));
        x402Field.setText(resultList.get(10));
        x403Field.setText(resultList.get(11));
        x404Field.setText(resultList.get(12));
        switch (resultList.get(13)) {
            case "1":
                x405Field.setText("Ні");
                break;
            case "2":
                x405Field.setText("В перший день");
                break;
            case "3":
                x405Field.setText("В другий день");
                break;
            case "4":
                x405Field.setText("В третій день");
                break;
            case "5":
                x405Field.setText("В четвертий день");
                break;
            case "6":
                x405Field.setText("В пятий день");
                break;
            default:
                x405Field.setText("В шостий день");
                break;
        }
        switch (resultList.get(14)) {
            case "1":
                x406Field.setText("Ні");
                break;
            case "2":
                x406Field.setText("В перший день");
                break;
            case "3":
                x406Field.setText("В другий день");
                break;
            default:
                x406Field.setText("В третій день");
                break;
        }
        switch (resultList.get(15)) {
            case "1":
                x407Field.setText("Ні");
                break;
            case "2":
                x407Field.setText("Дексон");
                break;
            default:
                x407Field.setText("Преднізолон");
                break;
        }
        if (resultList.get(16).equals("1")) {
            x408Field.setText("Так");
        } else {
            x408Field.setText("Ні");
        }
        if (resultList.get(17).equals("1")) {
            x409Field.setText("Так");
        } else {
            x409Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x501Field.setText("Ні");
        } else {
            x501Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x502Field.setText("Ні");
        } else {
            x502Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x503Field.setText("Ні");
        } else {
            x503Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x504Field.setText("Ні");
        } else {
            x504Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x505Field.setText("Ні");
        } else {
            x505Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x506Field.setText("Ні");
        } else {
            x506Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x507Field.setText("Ні");
        } else {
            x507Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x508Field.setText("Ні");
        } else {
            x508Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x509Field.setText("Ні");
        } else {
            x509Field.setText("Так");
        }
    }

    @FXML
    public void variant3() {
        x401Field.setText(resultList.get(18));
        x402Field.setText(resultList.get(19));
        x403Field.setText(resultList.get(20));
        x404Field.setText(resultList.get(21));
        switch (resultList.get(22)) {
            case "1":
                x405Field.setText("Ні");
                break;
            case "2":
                x405Field.setText("В перший день");
                break;
            case "3":
                x405Field.setText("В другий день");
                break;
            case "4":
                x405Field.setText("В третій день");
                break;
            case "5":
                x405Field.setText("В четвертий день");
                break;
            case "6":
                x405Field.setText("В пятий день");
                break;
            default:
                x405Field.setText("В шостий день");
                break;
        }
        switch (resultList.get(23)) {
            case "1":
                x406Field.setText("Ні");
                break;
            case "2":
                x406Field.setText("В перший день");
                break;
            case "3":
                x406Field.setText("В другий день");
                break;
            default:
                x406Field.setText("В третій день");
                break;
        }
        switch (resultList.get(24)) {
            case "1":
                x407Field.setText("Ні");
                break;
            case "2":
                x407Field.setText("Дексон");
                break;
            default:
                x407Field.setText("Преднізолон");
                break;
        }
        if (resultList.get(25).equals("1")) {
            x408Field.setText("Так");
        } else {
            x408Field.setText("Ні");
        }
        if (resultList.get(26).equals("1")) {
            x409Field.setText("Так");
        } else {
            x409Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x501Field.setText("Ні");
        } else {
            x501Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x502Field.setText("Ні");
        } else {
            x502Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x503Field.setText("Ні");
        } else {
            x503Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x504Field.setText("Ні");
        } else {
            x504Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x505Field.setText("Ні");
        } else {
            x505Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x506Field.setText("Ні");
        } else {
            x506Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x507Field.setText("Ні");
        } else {
            x507Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x508Field.setText("Ні");
        } else {
            x508Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x509Field.setText("Ні");
        } else {
            x509Field.setText("Так");
        }
    }

    @FXML
    public void variant4() {
        x401Field.setText(resultList.get(27));
        x402Field.setText(resultList.get(28));
        x403Field.setText(resultList.get(29));
        x404Field.setText(resultList.get(30));
        switch (resultList.get(31)) {
            case "1":
                x405Field.setText("Ні");
                break;
            case "2":
                x405Field.setText("В перший день");
                break;
            case "3":
                x405Field.setText("В другий день");
                break;
            case "4":
                x405Field.setText("В третій день");
                break;
            case "5":
                x405Field.setText("В четвертий день");
                break;
            case "6":
                x405Field.setText("В пятий день");
                break;
            default:
                x405Field.setText("В шостий день");
                break;
        }
        switch (resultList.get(32)) {
            case "1":
                x406Field.setText("Ні");
                break;
            case "2":
                x406Field.setText("В перший день");
                break;
            case "3":
                x406Field.setText("В другий день");
                break;
            default:
                x406Field.setText("В третій день");
                break;
        }
        switch (resultList.get(33)) {
            case "1":
                x407Field.setText("Ні");
                break;
            case "2":
                x407Field.setText("Дексон");
                break;
            default:
                x407Field.setText("Преднізолон");
                break;
        }
        if (resultList.get(34).equals("1")) {
            x408Field.setText("Так");
        } else {
            x408Field.setText("Ні");
        }
        if (resultList.get(35).equals("1")) {
            x409Field.setText("Так");
        } else {
            x409Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x501Field.setText("Ні");
        } else {
            x501Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x502Field.setText("Ні");
        } else {
            x502Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x503Field.setText("Ні");
        } else {
            x503Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x504Field.setText("Ні");
        } else {
            x504Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x505Field.setText("Ні");
        } else {
            x505Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x506Field.setText("Ні");
        } else {
            x506Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x507Field.setText("Ні");
        } else {
            x507Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x508Field.setText("Ні");
        } else {
            x508Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x509Field.setText("Ні");
        } else {
            x509Field.setText("Так");
        }
    }

    @FXML
    public void variant5() {
        x401Field.setText(resultList.get(36));
        x402Field.setText(resultList.get(37));
        x403Field.setText(resultList.get(38));
        x404Field.setText(resultList.get(39));
        switch (resultList.get(40)) {
            case "1":
                x405Field.setText("Ні");
                break;
            case "2":
                x405Field.setText("В перший день");
                break;
            case "3":
                x405Field.setText("В другий день");
                break;
            case "4":
                x405Field.setText("В третій день");
                break;
            case "5":
                x405Field.setText("В четвертий день");
                break;
            case "6":
                x405Field.setText("В пятий день");
                break;
            default:
                x405Field.setText("В шостий день");
                break;
        }
        switch (resultList.get(41)) {
            case "1":
                x406Field.setText("Ні");
                break;
            case "2":
                x406Field.setText("В перший день");
                break;
            case "3":
                x406Field.setText("В другий день");
                break;
            default:
                x406Field.setText("В третій день");
                break;
        }
        switch (resultList.get(42)) {
            case "1":
                x407Field.setText("Ні");
                break;
            case "2":
                x407Field.setText("Дексон");
                break;
            default:
                x407Field.setText("Преднізолон");
                break;
        }
        if (resultList.get(43).equals("1")) {
            x408Field.setText("Так");
        } else {
            x408Field.setText("Ні");
        }
        if (resultList.get(44).equals("1")) {
            x409Field.setText("Так");
        } else {
            x409Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x501Field.setText("Ні");
        } else {
            x501Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x502Field.setText("Ні");
        } else {
            x502Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x503Field.setText("Ні");
        } else {
            x503Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x504Field.setText("Ні");
        } else {
            x504Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x505Field.setText("Ні");
        } else {
            x505Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x506Field.setText("Ні");
        } else {
            x506Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x507Field.setText("Ні");
        } else {
            x507Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x508Field.setText("Ні");
        } else {
            x508Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x509Field.setText("Ні");
        } else {
            x509Field.setText("Так");
        }
    }
}
