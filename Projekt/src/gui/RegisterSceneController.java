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
        comboBox.getItems().addAll("Detské konto", "Konto pre dospelých", "Konto pre pracovníkov");
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
                        lib.getSysAcc().addNewUserChildReader(nameText.getText(), loginText.getText(), passText.getText());
                        break;
                    }
                    case ("Konto pre dospelých"): {
                        lib.getSysAcc().addNewUserAdultReader(nameText.getText(), loginText.getText(), passText.getText());
                        break;
                    }
                    case ("Konto pre pracovníkov"): {
                        lib.getSysAcc().addNewUserWorker(nameText.getText(), loginText.getText(), passText.getText());
                        break;
                    }
                }
                AlertSystem errorWindow = new AlertSystem("Informácia", "Účet vytvorený");
                lib.serializeOffice();
                switchScene("logInScene.fxml", actionEvent);
            }
        }

    }

}
