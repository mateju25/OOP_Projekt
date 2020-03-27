package LogInScene;

import Services.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController extends SimpleController {
    @FXML
    private TextField loginText;
    @FXML
    private TextField passText;

    private String pass = "";
    private int currLet = 0;

    @FXML
    private void logInButtonClicked(ActionEvent event) throws IOException {
        if(lib.findUser(loginText.getText(), pass) == 1) {
            currLet = 0;
            pass = "";
            FXMLLoader loader = new FXMLLoader((getClass().getResource(lib.getActiveUser().getOwner().startScene())));
            Parent root = loader.load();
            LogOutController logOutController = loader.getController();
            logOutController.transferData(this.lib);
            Scene scene = new Scene(root);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }
        else {
            AlertSystem wrongloginWindow = new AlertSystem("Pozor", "Zadaj login alebo heslo");
        }
    }

    @FXML
    private void showStars() throws IOException {
        String s = "";
        pass += passText.getText().charAt(currLet);
        currLet++;
        for (int i = 0; i < currLet; i++) {
            s += "*";
        }
        passText.setText(s);
        passText.positionCaret(currLet);
    }

    @FXML
    private void newUserButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader((getClass().getResource("registerScene.fxml")));
        Parent root = loader.load();
        RegisterSceneController registerSceneController = loader.getController();
        registerSceneController.transferData(this.lib);
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }


    @FXML
    private void quitButton(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }


}

