package LogInScene;

import Library.Request;
import People.Worker;
import Products.Message;
import Services.Account;
import Services.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class RequestController extends SimpleController{
    @FXML
    private TextArea plainText;
    @FXML
    private Button nextReq;
    @FXML
    private Button acceptButton;
    @FXML
    private Button declineButton;
    @FXML
    private Button accountInfo;
    @FXML
    private void goBackButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader((getClass().getResource(lib.getSysAcc().getCurrUser().getOwner().startScene())));
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
        Request req = lib.getSysReq().nextRequest();
        if (req != null) {
            plainText.clear();
            plainText.appendText(req.showMessage());
        }
        else
        {
            if (lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysReq()).size() == 0) {
                AlertSystem alertWindow = new AlertSystem("Informacia", "Ziadne dalsie poziadavky");
                acceptButton.setDisable(true);
                declineButton.setDisable(true);
                accountInfo.setDisable(true);
            }
            else
                prevRequestButton(event);
        }
    }

    @FXML
    private void prevRequestButton(ActionEvent event) {
        nextReq.setDisable(false);
        if (lib.getSysReq().beginRequest() != null) {
            plainText.clear();
            plainText.appendText(lib.getSysReq().beginRequest().showMessage());
            acceptButton.setDisable(false);
            declineButton.setDisable(false);
            accountInfo.setDisable(false);
        } else
        {
            nextReq.setDisable(true);
            AlertSystem alertWindow = new AlertSystem("Informacia", "Ziadne dalsie poziadavky");
        }
    }

    @FXML
    private void acceptRequestButton(ActionEvent event) throws IOException {
        Request reg = lib.getSysReq().getCurrRequest();
        reg.acceptRequest((Worker)(lib.getSysAcc().getCurrUser().getOwner()));
        lib.getSysReq().deleteRequest();
        plainText.clear();
        if (lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysReq()).size() == 0)
        {
            acceptButton.setDisable(true);
            declineButton.setDisable(true);
            declineButton.setDisable(true);
            accountInfo.setDisable(true);
            nextReq.setDisable(true);
        }
        else
            nextRequestButton(event);
    }

    @FXML
    private void declineRequestButton(ActionEvent event) throws IOException {
        lib.getSysReq().getCurrRequest().declineRequest();
        lib.getSysReq().deleteRequest();
        plainText.clear();
        if (lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysReq()).size() == 0)
        {
            acceptButton.setDisable(true);
            declineButton.setDisable(true);
            declineButton.setDisable(true);
            accountInfo.setDisable(true);
            nextReq.setDisable(true);
        }
        else
            nextRequestButton(event);
    }


    @FXML
    private void showUserData(ActionEvent event) {
        Account acc = lib.getSysReq().getCurrRequest().getRequester();
        AlertSystem infoWindow = new AlertSystem("Info o žiadateľovi", "Meno a priezvisko: " + acc.getOwner().getName() + "\n" + "Stav účtu: " + acc.getBill());
    }
}
