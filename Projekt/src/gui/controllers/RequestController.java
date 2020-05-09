package gui.controllers;

import products.AccountRequest;
import products.Request;
import people.Worker;
import products.Account;
import systems.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * This controller provides handlers for handling requests scene for {@link people.Librarian}
 */
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
    private Label statusBar;

    //vrati sa spat na predchadzajucu scenu
    @FXML
    private void goBackButton(ActionEvent event) {
        switchScene(lib.getSysAcc().getCurrUser().getOwner().startScene(), event);
    }

    /**
     * Sets test for status bar in the scene
     */
    public void setStatusBar()
    {
        statusBar.setText("  Prihlásený užívateľ: " + lib.getSysAcc().getCurrUser().getOwner().getName());
    }

    @FXML
    private void logOutButtonClicked(ActionEvent event) throws InterruptedException {
        lib.serializeOffice();
        lib.getSysAcc().getCurrUser().userLogOut();
        switchScene("../View/logInScene.fxml", event);
    }

    //zobraz dalsiu poziadavku
    @FXML
    private void nextRequestButton(ActionEvent event) {
        Request req = lib.getSysReq().nextRequest();
        if (req != null) {
            plainText.clear();
            plainText.appendText(req.getInfo());
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
    //zobraz prvu poziadavku v zozname
    @FXML
    private void prevRequestButton(ActionEvent event) {
        nextReq.setDisable(false);
        if (lib.getSysReq().beginRequest() != null) {
            plainText.clear();
            plainText.appendText(lib.getSysReq().beginRequest().getInfo());
            acceptButton.setDisable(false);
            declineButton.setDisable(false);
            accountInfo.setDisable(false);
        } else
        {
            nextReq.setDisable(true);
            AlertSystem alertWindow = new AlertSystem("Informacia", "Ziadne dalsie poziadavky");
        }
    }
    //akceptuj poziadavku od uzivatela
    @FXML
    private void acceptRequestButton(ActionEvent event) throws InterruptedException {
        Request reg = lib.getSysReq().getCurrRequest();
        reg.acceptRequest((Worker)(lib.getSysAcc().getCurrUser().getOwner()));
        lib.getSysReq().deleteRequest();
        plainText.clear();
        setButttons(event);
        lib.serializeOffice();
    }
    //zavrhni poziadavku od uzivatela
    @FXML
    private void declineRequestButton(ActionEvent event) throws InterruptedException {
        lib.getSysReq().getCurrRequest().declineRequest((Worker)(lib.getSysAcc().getCurrUser().getOwner()));
        if (lib.getSysReq().getCurrRequest() instanceof AccountRequest) lib.getSysAcc().deleteAccount(lib.getSysReq().getCurrRequest().getRequester().getOwner().getID());
        lib.getSysReq().deleteRequest();
        plainText.clear();
        setButttons(event);
        lib.serializeOffice();
    }
    //nastav tlacidla na pouzitelne
    private void setButttons(ActionEvent event)
    {
        if (lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysReq()).size() == 0)
        {
            acceptButton.setDisable(true);
            declineButton.setDisable(true);
            accountInfo.setDisable(true);
            nextReq.setDisable(true);
        }
        else
            nextRequestButton(event);
    }

    //vypis okno a udajmi o ziadatelovi
    @FXML
    private void showUserData(ActionEvent event) {
        Account acc = lib.getSysReq().getCurrRequest().getRequester();
        AlertSystem infoWindow = new AlertSystem("Info o žiadateľovi", "Meno a priezvisko: " + acc.getOwner().getName() + "\n");
    }
}
