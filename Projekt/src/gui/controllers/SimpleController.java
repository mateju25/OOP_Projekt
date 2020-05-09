package gui.controllers;

import products.Book;
import systems.LibraryEvidenceSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This controller provides basic operations for all controllers
 */
public class SimpleController {
    /**
     * Library system
     */
    protected LibraryEvidenceSystem lib;
    /**
     * Main window of the program
     */
    protected Stage mainWindow;

    /**
     * transfers data between controllers
     * @param paLib {@link LibraryEvidenceSystem}
     * @param window main window of the program
     */
    public void transferData(LibraryEvidenceSystem paLib, Stage window)
    {
        this.lib = paLib;
        this.mainWindow = window;
    }

    /**
     * saves data
     */
    @FXML
    public void saveLibrary() {
        try {
            lib.serializeOffice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * switches scenes between controllers
     * @param s name of the file for switching
     * @param event event that has started
     */
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
            case ("../View/logOutSceneClient.fxml") : {
                ((LogOutControllerClient)controller).setMessText();
                break;
            }
            case ("../View/logOutSceneLibrarian.fxml") : {
                ((LogOutControllerLibrarian)controller).setStatusBar();
                break;
            }
            case ("../View/logOutSceneLBookStocker.fxml") : {
                ((LogOutControllerBookStocker)controller).setStatusBar();
                break;
            }
            case ("../View/registerScene.fxml") : {
                break;
            }
            case ("../View/requestScene.fxml") : {
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
