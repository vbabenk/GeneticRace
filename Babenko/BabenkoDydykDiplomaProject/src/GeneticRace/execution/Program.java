// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.execution;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Program extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GeneticRace/login/LoginView.fxml"));
        Parent root = loader.load();
        stage.setTitle("Авторизація в системі");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("file:D:\\JavaProjects\\Babenko\\Images\\logo.png"));
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
