package gui;

import Systems.AlertSystem;
import Systems.PasswordChecker;
import Systems.WrongPasswordException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class RegisterSceneController extends SimpleController {
    @FXML
    private TextField nameText;
    @FXML
    private TextField loginText;
    @FXML
    private TextField passText;
    @FXML
    private ChoiceBox comboBox;

    private String pass = "";
    private int currLet = 0;

    @FXML
    public void initialize() {
        comboBox.getItems().addAll("Detské konto", "Konto pre dospelých");
    }

    //registrovanie noveho uzivatela
    public void registerButtonClick(ActionEvent actionEvent) throws InterruptedException {
        if (nameText.getText().equals("") || loginText.getText().equals("") || passText.getText().equals("") || comboBox.getSelectionModel().isEmpty()) {
            AlertSystem errorWindow = new AlertSystem("Pozor", "Nevyplnil si všetky údaje");
        }
        else {
            if (lib.getSysAcc().findUser(loginText.getText())) {
                AlertSystem errorWindow = new AlertSystem("Pozor", "Už existuje používateľ s rovnakým menom");
            }
            else {
                PasswordChecker checker = new PasswordChecker();
                try {
                    checker.checkPass(passText.getText());
                } catch (WrongPasswordException e) {
                    return;
                }
                switch ((String) comboBox.getSelectionModel().getSelectedItem()) {
                    case ("Detské konto"): {
                        lib.getSysAcc().addNewUserChildReader(nameText.getText(), loginText.getText(), passText.getText(), false);
                        break;
                    }
                    case ("Konto pre dospelých"): {
                        lib.getSysAcc().addNewUserAdultReader(nameText.getText(), loginText.getText(), passText.getText(), false);
                        break;
                    }
                }
                AlertSystem errorWindow = new AlertSystem("Informácia", "Účet vytvorený");
                lib.getSysReq().addNewAccountReq(lib.getSysAcc().findAccountName(nameText.getText()));
                lib.serializeOffice();
                switchScene("logInScene.fxml", actionEvent);
            }
        }

    }


    //registrovanie noveho uzivatela
    public void goBackButton(ActionEvent actionEvent) {
        switchScene("logInScene.fxml", actionEvent);
    }

}
