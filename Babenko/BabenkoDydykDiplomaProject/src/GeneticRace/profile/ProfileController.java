package GeneticRace.profile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


public class ProfileController {
    private ProfileModel profileModel;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField middlenameField;
    @FXML
    private ChoiceBox<String> sexBox;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField secondDoctorField;
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
    private ChoiceBox<String> hypertrophyBox;
    @FXML
    private ChoiceBox<String> rBox;
    @FXML
    private ChoiceBox<String> basBox;
    @FXML
    private Button backBtn;

    @FXML
    public void initialize() {
        profileModel = new ProfileModel();
        ObservableList<String> sexList = FXCollections.observableArrayList("Чоловіча", "Жіноча");
        ObservableList<String> yesNoList = FXCollections.observableArrayList("Так", "Ні");
        sexBox.setItems(sexList);
        hypertrophyBox.setItems(yesNoList);
        rBox.setItems(yesNoList);
        basBox.setItems(yesNoList);
        sexBox.getSelectionModel().selectFirst();
        hypertrophyBox.getSelectionModel().selectFirst();
        rBox.getSelectionModel().selectFirst();
        basBox.getSelectionModel().selectFirst();
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
    public void addToDatabase() throws SQLException, ParseException, IOException {
        String surname = surnameField.getText();
        String firstname = firstnameField.getText();
        String middlename = middlenameField.getText();
        String sex = sexBox.getValue();
        String birthday = birthdayField.getText();
        String secondDoctor = secondDoctorField.getText();
        String lpa = lpaField.getText();
        String nakata = nakataField.getText();
        String vedp = vedpField.getText();
        String ppa = ppaField.getText();
        String edi = ediField.getText();
        String pvr = pvrField.getText();
        String risk = riskField.getText();
        String zScore = zScoreField.getText();
        String hypertrophy = hypertrophyBox.getValue();
        String r = rBox.getValue();
        String bas = basBox.getValue();
        profileModel.addNewPatient(surname, firstname, middlename, sex, birthday, secondDoctor, lpa, nakata, vedp, ppa,
                edi, pvr, risk, zScore, hypertrophy, r, bas);
    }
}
