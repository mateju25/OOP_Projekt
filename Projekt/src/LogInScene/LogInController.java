package LogInScene;

import Services.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
            FXMLLoader loader = new FXMLLoader((getClass().getResource(lib.getSysAcc().getCurrUser().getOwner().startScene())));
            Parent root = loader.load();
            LogOutController logOutController = loader.getController();
            logOutController.transferData(this.lib);
            Scene scene = new Scene(root);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }
        else {
            AlertSystem wrongloginWindow = new AlertSystem("Pozor", "Zadaj správny login alebo heslo");
        }
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
    private void quitButton(ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        lib.serializeOffice();
        window.close();
    }


}

