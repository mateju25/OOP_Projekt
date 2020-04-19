package gui;

import Systems.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController extends SimpleController {
    @FXML
    private TextField loginText;
    @FXML
    private TextField passText;


    //stlacenie prihlasovancieho tlacidla
    @FXML
    private void logInButtonClicked(ActionEvent event) throws IOException {
        if(lib.getSysAcc().logUser(loginText.getText(), passText.getText()) == 1) {
            switchScene(lib.getSysAcc().getCurrUser().getOwner().startScene(), event);
        }
        else {
            AlertSystem wrongloginWindow;
            if (lib.getSysAcc().findAccountName(loginText.getText()) != null) {
                if (lib.getSysAcc().findAccountName(loginText.getText()).getVerified() == false)
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
    private void newUserButton(ActionEvent event) throws IOException {
        switchScene("registerScene.fxml", event);
    }

    //stlacenie ukoncovacieho tlacidla
    @FXML
    private void quitButton(ActionEvent event) throws InterruptedException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        lib.serializeOffice();
        window.close();
    }


}

