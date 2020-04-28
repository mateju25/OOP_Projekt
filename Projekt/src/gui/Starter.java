package gui;

import Systems.LibraryEvidenceSystem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Starter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader((getClass().getResource("logInScene.fxml")));
        Parent root = loader.load();
        LogInController logInController = loader.getController();
        logInController.transferData(new LibraryEvidenceSystem(), primaryStage);

        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../data/Logo.png")));
        primaryStage.setTitle("LibBook");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

