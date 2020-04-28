package gui;

import Systems.LibraryEvidenceSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SimpleController {
    //atributes
    protected LibraryEvidenceSystem lib;
    protected Stage mainWindow;

    //methods
    public void transferData(LibraryEvidenceSystem paLib, Stage window)
    {
        this.lib = paLib;
        this.mainWindow = window;
    }

    @FXML
    public void saveLibrary() {
        System.out.println("saved");
        try {
            lib.serializeOffice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void switchScene(String s, ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader((getClass().getResource(s)));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleController controller = loader.getController();
        controller.transferData(this.lib, this.mainWindow);
        switch (s)
        {
            case ("logOutSceneClient.fxml") : {
                ((LogOutControllerClient)controller).setMessText();
                break;
            }
            case ("logOutSceneLibrarian.fxml") : {
                ((LogOutControllerLibrarian)controller).setStatusBar();
                break;
            }
            case ("logOutSceneLBookStocker.fxml") : {
                ((LogOutControllerBookStocker)controller).setStatusBar();
                break;
            }
            case ("registerScene.fxml") : {
                break;
            }
            case ("requestScene.fxml") : {
                ((RequestController)controller).setStatusBar();
                break;
            }
            default: break;
        }

        Scene scene = new Scene(root);
        mainWindow.setScene(scene);
        mainWindow.show();
    }
}
