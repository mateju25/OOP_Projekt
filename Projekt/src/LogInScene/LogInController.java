package LogInScene;

import Library.Office;
import Services.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {
    private Office lib;

    @FXML
    private TextField loginText;
    @FXML
    private TextField passText;

    @FXML
    private void logInButtonClicked(ActionEvent event) throws IOException {
       // if(lib.findUser(loginText.getText(), "x") == 1) {
        if(loginText.getText().equals("") || passText.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacia");
            alert.setHeaderText(null);
            alert.setContentText("Zadaj login a heslo");

            alert.showAndWait();
        }
        else
            if(lib.findUser(loginText.getText(), passText.getText()) == 1) {
                FXMLLoader loader = new FXMLLoader((getClass().getResource(lib.getActiveUser().getOwner().startScene())));
                Parent root = loader.load();
                LogOutController logOutController = loader.getController();
                logOutController.transferData(this.lib);
                Scene scene = new Scene(root);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(scene);
                window.show();
            }
    }

    @FXML
    private void quitButton(ActionEvent event) throws IOException {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    public void transferData(Office paLib)
    {
        this.lib = paLib;
    }
}

