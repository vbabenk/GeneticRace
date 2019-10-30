package GeneticRace.firstStage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class FirstStageController {
    private FirstStageModel fsModel;
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
    private TextField ageField;
    @FXML
    private TextField lpaField;
    @FXML
    private TextField nakataField;
    @FXML
    private TextField vedpField;
    @FXML
    private TextField ppaField;
    @FXML
    private TextField ediField;
    @FXML
    private TextField pvrField;
    @FXML
    private TextField riskField;
    @FXML
    private TextField zScoreField;
    @FXML
    private TextField hypertrophyField;
    @FXML
    private TextField rField;
    @FXML
    private TextField basField;
    @FXML
    private TextField x201Field;
    @FXML
    private TextField x202Field;
    @FXML
    private TextField x203Field;
    @FXML
    private TextField x204Field;
    @FXML
    private TextField x205Field;
    @FXML
    private TextField x206Field;
    @FXML
    private TextField x207Field;
    @FXML
    private TextField x208Field;
    @FXML
    private TextField x209Field;
    @FXML
    private TextField x301Field;
    @FXML
    private TextField x302Field;
    @FXML
    private TextField x303Field;
    @FXML
    private TextField x304Field;
    @FXML
    private TextField x305Field;
    @FXML
    private TextField x306Field;
    @FXML
    private TextField x307Field;
    @FXML
    private TextField x308Field;
    @FXML
    private TextField x309Field;
    @FXML
    private Button predictBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Button addBtn;

    private void setFields() {
        surnameField.setText(patient.get(0));
        firstnameField.setText(patient.get(1));
        middlenameField.setText(patient.get(2));
        sexField.setText(patient.get(3));
        birthdayField.setText(patient.get(4));
        ageField.setText(patient.get(5));
        lpaField.setText(patient.get(6));
        nakataField.setText(patient.get(7));
        vedpField.setText(patient.get(8));
        ppaField.setText(patient.get(9));
        ediField.setText(patient.get(10));
        pvrField.setText(patient.get(11));
        riskField.setText(patient.get(12));
        zScoreField.setText(patient.get(13));
        hypertrophyField.setText(patient.get(14));
        rField.setText(patient.get(15));
        basField.setText(patient.get(16));
    }

    @FXML
    public void initialize() throws SQLException, IOException {
        fsModel = new FirstStageModel();
        patient = fsModel.loadPatient();
        setFields();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaProjects\\Babenko\\Files\\userRole.txt"));
        String currLine;
        while ((currLine = reader.readLine()) != null) {
            userRole = currLine;
        }
        reader.close();
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
        resultList = fsModel.calculateTreatment(patient);
        x201Field.setText(resultList.get(0));
        x202Field.setText(resultList.get(1));
        x203Field.setText(resultList.get(2));
        switch (resultList.get(3)) {
            case "1":
                x204Field.setText("RPA");
                break;
            case "2":
                x204Field.setText("RPA+MPA");
                break;
            case "3":
                x204Field.setText("MPA");
                break;
            case "4":
                x204Field.setText("LPA+MPA");
                break;
            default:
                x204Field.setText("Стандартний");
                break;
        }
        if (resultList.get(4).equals("1")) {
            x205Field.setText("Так");
        } else {
            x205Field.setText("Ні");
        }
        if (resultList.get(5).equals("1")) {
            x206Field.setText("Так");
        } else {
            x206Field.setText("Ні");
        }
        if (resultList.get(6).equals("1")) {
            x207Field.setText("Так");
        } else {
            x207Field.setText("Ні");
        }
        if (resultList.get(7).equals("1")) {
            x208Field.setText("Так");
        } else {
            x208Field.setText("Ні");
        }
        if (resultList.get(8).equals("1")) {
            x209Field.setText("Так");
        } else {
            x209Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x301Field.setText("Ні");
        } else {
            x301Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x302Field.setText("Ні");
        } else {
            x302Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x303Field.setText("Ні");
        } else {
            x303Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x304Field.setText("Ні");
        } else {
            x304Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x305Field.setText("Ні");
        } else {
            x305Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x306Field.setText("Ні");
        } else {
            x306Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x307Field.setText("Ні");
        } else {
            x307Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x308Field.setText("Ні");
        } else {
            x308Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x309Field.setText("Ні");
        } else {
            x309Field.setText("Так");
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
        resultList.add(x201Field.getText());
        resultList.add(x202Field.getText());
        resultList.add(x203Field.getText());
        resultList.add(x204Field.getText());
        resultList.add(x205Field.getText());
        resultList.add(x206Field.getText());
        resultList.add(x207Field.getText());
        resultList.add(x208Field.getText());
        resultList.add(x209Field.getText());
        fsModel.saveResult(resultList);
    }

    @FXML
    public void variant1() {
        x201Field.setText(resultList.get(0));
        x202Field.setText(resultList.get(1));
        x203Field.setText(resultList.get(2));
        switch (resultList.get(3)) {
            case "1":
                x204Field.setText("RPA");
                break;
            case "2":
                x204Field.setText("RPA+MPA");
                break;
            case "3":
                x204Field.setText("MPA");
                break;
            case "4":
                x204Field.setText("LPA+MPA");
                break;
            default:
                x204Field.setText("Стандартний");
                break;
        }
        if (resultList.get(4).equals("1")) {
            x205Field.setText("Так");
        } else {
            x205Field.setText("Ні");
        }
        if (resultList.get(5).equals("1")) {
            x206Field.setText("Так");
        } else {
            x206Field.setText("Ні");
        }
        if (resultList.get(6).equals("1")) {
            x207Field.setText("Так");
        } else {
            x207Field.setText("Ні");
        }
        if (resultList.get(7).equals("1")) {
            x208Field.setText("Так");
        } else {
            x208Field.setText("Ні");
        }
        if (resultList.get(8).equals("1")) {
            x209Field.setText("Так");
        } else {
            x209Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x301Field.setText("Ні");
        } else {
            x301Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x302Field.setText("Ні");
        } else {
            x302Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x303Field.setText("Ні");
        } else {
            x303Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x304Field.setText("Ні");
        } else {
            x304Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x305Field.setText("Ні");
        } else {
            x305Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x306Field.setText("Ні");
        } else {
            x306Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x307Field.setText("Ні");
        } else {
            x307Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x308Field.setText("Ні");
        } else {
            x308Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x309Field.setText("Ні");
        } else {
            x309Field.setText("Так");
        }
    }

    @FXML
    public void variant2() {
        x201Field.setText(resultList.get(9));
        x202Field.setText(resultList.get(10));
        x203Field.setText(resultList.get(11));
        switch (resultList.get(12)) {
            case "1":
                x204Field.setText("RPA");
                break;
            case "2":
                x204Field.setText("RPA+MPA");
                break;
            case "3":
                x204Field.setText("MPA");
                break;
            case "4":
                x204Field.setText("LPA+MPA");
                break;
            default:
                x204Field.setText("Стандартний");
                break;
        }
        if (resultList.get(13).equals("1")) {
            x205Field.setText("Так");
        } else {
            x205Field.setText("Ні");
        }
        if (resultList.get(14).equals("1")) {
            x206Field.setText("Так");
        } else {
            x206Field.setText("Ні");
        }
        if (resultList.get(15).equals("1")) {
            x207Field.setText("Так");
        } else {
            x207Field.setText("Ні");
        }
        if (resultList.get(16).equals("1")) {
            x208Field.setText("Так");
        } else {
            x208Field.setText("Ні");
        }
        if (resultList.get(17).equals("1")) {
            x209Field.setText("Так");
        } else {
            x209Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x301Field.setText("Ні");
        } else {
            x301Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x302Field.setText("Ні");
        } else {
            x302Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x303Field.setText("Ні");
        } else {
            x303Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x304Field.setText("Ні");
        } else {
            x304Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x305Field.setText("Ні");
        } else {
            x305Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x306Field.setText("Ні");
        } else {
            x306Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x307Field.setText("Ні");
        } else {
            x307Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x308Field.setText("Ні");
        } else {
            x308Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x309Field.setText("Ні");
        } else {
            x309Field.setText("Так");
        }
    }

    @FXML
    public void variant3() {
        x201Field.setText(resultList.get(18));
        x202Field.setText(resultList.get(19));
        x203Field.setText(resultList.get(20));
        switch (resultList.get(21)) {
            case "1":
                x204Field.setText("RPA");
                break;
            case "2":
                x204Field.setText("RPA+MPA");
                break;
            case "3":
                x204Field.setText("MPA");
                break;
            case "4":
                x204Field.setText("LPA+MPA");
                break;
            default:
                x204Field.setText("Стандартний");
                break;
        }
        if (resultList.get(22).equals("1")) {
            x205Field.setText("Так");
        } else {
            x205Field.setText("Ні");
        }
        if (resultList.get(23).equals("1")) {
            x206Field.setText("Так");
        } else {
            x206Field.setText("Ні");
        }
        if (resultList.get(24).equals("1")) {
            x207Field.setText("Так");
        } else {
            x207Field.setText("Ні");
        }
        if (resultList.get(25).equals("1")) {
            x208Field.setText("Так");
        } else {
            x208Field.setText("Ні");
        }
        if (resultList.get(26).equals("1")) {
            x209Field.setText("Так");
        } else {
            x209Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x301Field.setText("Ні");
        } else {
            x301Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x302Field.setText("Ні");
        } else {
            x302Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x303Field.setText("Ні");
        } else {
            x303Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x304Field.setText("Ні");
        } else {
            x304Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x305Field.setText("Ні");
        } else {
            x305Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x306Field.setText("Ні");
        } else {
            x306Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x307Field.setText("Ні");
        } else {
            x307Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x308Field.setText("Ні");
        } else {
            x308Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x309Field.setText("Ні");
        } else {
            x309Field.setText("Так");
        }
    }

    @FXML
    public void variant4() {
        x201Field.setText(resultList.get(27));
        x202Field.setText(resultList.get(28));
        x203Field.setText(resultList.get(29));
        switch (resultList.get(30)) {
            case "1":
                x204Field.setText("RPA");
                break;
            case "2":
                x204Field.setText("RPA+MPA");
                break;
            case "3":
                x204Field.setText("MPA");
                break;
            case "4":
                x204Field.setText("LPA+MPA");
                break;
            default:
                x204Field.setText("Стандартний");
                break;
        }
        if (resultList.get(31).equals("1")) {
            x205Field.setText("Так");
        } else {
            x205Field.setText("Ні");
        }
        if (resultList.get(32).equals("1")) {
            x206Field.setText("Так");
        } else {
            x206Field.setText("Ні");
        }
        if (resultList.get(33).equals("1")) {
            x207Field.setText("Так");
        } else {
            x207Field.setText("Ні");
        }
        if (resultList.get(34).equals("1")) {
            x208Field.setText("Так");
        } else {
            x208Field.setText("Ні");
        }
        if (resultList.get(35).equals("1")) {
            x209Field.setText("Так");
        } else {
            x209Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x301Field.setText("Ні");
        } else {
            x301Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x302Field.setText("Ні");
        } else {
            x302Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x303Field.setText("Ні");
        } else {
            x303Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x304Field.setText("Ні");
        } else {
            x304Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x305Field.setText("Ні");
        } else {
            x305Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x306Field.setText("Ні");
        } else {
            x306Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x307Field.setText("Ні");
        } else {
            x307Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x308Field.setText("Ні");
        } else {
            x308Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x309Field.setText("Ні");
        } else {
            x309Field.setText("Так");
        }
    }

    @FXML
    public void variant5() {
        x201Field.setText(resultList.get(36));
        x202Field.setText(resultList.get(37));
        x203Field.setText(resultList.get(38));
        switch (resultList.get(39)) {
            case "1":
                x204Field.setText("RPA");
                break;
            case "2":
                x204Field.setText("RPA+MPA");
                break;
            case "3":
                x204Field.setText("MPA");
                break;
            case "4":
                x204Field.setText("LPA+MPA");
                break;
            default:
                x204Field.setText("Стандартний");
                break;
        }
        if (resultList.get(40).equals("1")) {
            x205Field.setText("Так");
        } else {
            x205Field.setText("Ні");
        }
        if (resultList.get(41).equals("1")) {
            x206Field.setText("Так");
        } else {
            x206Field.setText("Ні");
        }
        if (resultList.get(42).equals("1")) {
            x207Field.setText("Так");
        } else {
            x207Field.setText("Ні");
        }
        if (resultList.get(43).equals("1")) {
            x208Field.setText("Так");
        } else {
            x208Field.setText("Ні");
        }
        if (resultList.get(44).equals("1")) {
            x209Field.setText("Так");
        } else {
            x209Field.setText("Ні");
        }
        if (resultList.get(45).equals("1")) {
            x301Field.setText("Ні");
        } else {
            x301Field.setText("Так");
        }
        if (resultList.get(46).equals("1")) {
            x302Field.setText("Ні");
        } else {
            x302Field.setText("Так");
        }
        if (resultList.get(47).equals("1")) {
            x303Field.setText("Ні");
        } else {
            x303Field.setText("Так");
        }
        if (resultList.get(48).equals("1")) {
            x304Field.setText("Ні");
        } else {
            x304Field.setText("Так");
        }
        if (resultList.get(49).equals("1")) {
            x305Field.setText("Ні");
        } else {
            x305Field.setText("Так");
        }
        if (resultList.get(50).equals("1")) {
            x306Field.setText("Ні");
        } else {
            x306Field.setText("Так");
        }
        if (resultList.get(51).equals("1")) {
            x307Field.setText("Ні");
        } else {
            x307Field.setText("Так");
        }
        if (resultList.get(52).equals("1")) {
            x308Field.setText("Ні");
        } else {
            x308Field.setText("Так");
        }
        if (resultList.get(53).equals("1")) {
            x309Field.setText("Ні");
        } else {
            x309Field.setText("Так");
        }
    }
}
