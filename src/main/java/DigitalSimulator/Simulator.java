package DigitalSimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Simulator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/DigitalSimulator/UI.fxml"));

        // Main Stage
        stage.setTitle("Simulator");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
