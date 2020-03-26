package LogInScene;

import Library.Office;
import Library.Request;
import Services.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class RequestController {
    private Office lib;

    @FXML
    private TextArea plainText;

    @FXML
    private Button nextReq;

    @FXML
    private void goBackButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader((getClass().getResource(lib.getActiveUser().startScene())));
        Parent root = loader.load();
        LogOutController logOutController = loader.getController();
        logOutController.transferData(this.lib);
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void nextRequestButton(ActionEvent event) throws IOException {
        Request req = lib.nextRequest();
        if (req != null) {
            plainText.clear();
            plainText.appendText(req.showMessage());
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Ziadne dalsie poziadavky");

            alert.showAndWait();
        }
    }

    @FXML
    private void prevRequestButton(ActionEvent event) throws IOException {
        Request req = lib.beginRequest();
        nextReq.setDisable(false);
        if (req != null) {
            plainText.clear();
            plainText.appendText(req.showMessage());
        } else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Ziadne dalsie poziadavky");

            alert.showAndWait();
        }
    }

    @FXML
    private void acceptRequestButton(ActionEvent event) throws IOException {
        Request req = lib.getCurrRequest();
        req.acceptRequest();
        lib.deleteRequest();
        plainText.clear();
    }

    public void transferData(Office paLib)
    {
        this.lib = paLib;
    }
}
