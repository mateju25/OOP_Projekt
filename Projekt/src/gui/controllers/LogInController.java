package gui.controllers;

import systems.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This controller provides handlers for log in scene
 */
public class LogInController extends SimpleController {
    @FXML
    private TextField loginText;
    @FXML
    private TextField passText;


    //stlacenie prihlasovancieho tlacidla
    @FXML
    private void logInButtonClicked(ActionEvent event) {
        if(lib.getSysAcc().logUser(loginText.getText(), passText.getText())) {
            switchScene(lib.getSysAcc().getCurrUser().getOwner().startScene(), event);
        }
        else {
            AlertSystem wrongloginWindow;
            if (lib.getSysAcc().findAccountName(loginText.getText()) != null) {
                if (!lib.getSysAcc().findAccountName(loginText.getText()).getVerified())
                    wrongloginWindow = new AlertSystem("Pozor", "Účet ešte nebol overený.");
                else
                    wrongloginWindow = new AlertSystem("Pozor", "Zadaj správny login alebo heslo");
            }
            else
                wrongloginWindow = new AlertSystem("Pozor", "Zadaj správny login alebo heslo");
        }
    }

    //stlacenie registrovacieho tlacidla
    @FXML
    private void newUserButton(ActionEvent event) {
        switchScene("../View/registerScene.fxml", event);
    }

    //stlacenie ukoncovacieho tlacidla
    @FXML
    private void quitButton(ActionEvent event) throws InterruptedException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        lib.serializeOffice();
        window.close();
    }


}

