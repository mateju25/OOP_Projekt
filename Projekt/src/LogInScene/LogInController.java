package LogInScene;

import Services.AlertSystem;
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

    @FXML
    private void logInButtonClicked(ActionEvent event) throws IOException {
        if(lib.getSysAcc().logUser(loginText.getText(), passText.getText()) == 1) {
            switchScene(lib.getSysAcc().getCurrUser().getOwner().startScene(), event);
        }
        else {
            AlertSystem wrongloginWindow = new AlertSystem("Pozor", "Zadaj správny login alebo heslo");
        }
    }

    @FXML
    private void newUserButton(ActionEvent event) throws IOException {
        switchScene("registerScene.fxml", event);
    }


    @FXML
    private void quitButton(ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        lib.serializeOffice();
        window.close();
    }


}

