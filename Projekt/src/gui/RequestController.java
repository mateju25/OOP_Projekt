package gui;

import Products.Request;
import People.Worker;
import Products.Account;
import Systems.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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

    //vrati sa spat na predchadzajucu scenu
    @FXML
    private void goBackButton(ActionEvent event) throws IOException {
        switchScene(lib.getSysAcc().getCurrUser().getOwner().startScene(), event);
    }
    //zobraz dalsiu poziadavku
    @FXML
    private void nextRequestButton(ActionEvent event) {
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
    //zobraz prvu poziadavku v zozname
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
    //akceptuj poziadavku od uzivatela
    @FXML
    private void acceptRequestButton(ActionEvent event) {
        Request reg = lib.getSysReq().getCurrRequest();
        reg.acceptRequest((Worker)(lib.getSysAcc().getCurrUser().getOwner()));
        lib.getSysReq().deleteRequest();
        plainText.clear();
        setButttons(event);
        lib.serializeOffice();
    }
    //zavrhni poziadavku od uzivatela
    @FXML
    private void declineRequestButton(ActionEvent event) {
        lib.getSysReq().getCurrRequest().declineRequest();
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
        AlertSystem infoWindow = new AlertSystem("Info o žiadateľovi", "Meno a priezvisko: " + acc.getOwner().getName() + "\n" + "Stav účtu: " + acc.getBill());
    }
}