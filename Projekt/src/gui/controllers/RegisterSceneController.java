package gui.controllers;

import people.BookStocker;
import systems.AlertSystem;
import systems.PasswordChecker;
import systems.WrongPasswordException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * This controller provides handlers for register scene
 */
public class RegisterSceneController extends SimpleController {
    @FXML
    private TextField nameText;
    @FXML
    private TextField loginText;
    @FXML
    private TextField passText;
    @FXML
    private ChoiceBox comboBox;

    /**
     * initialize choice box of the scene
     */
    @FXML
    public void initialize() {
        comboBox.getItems().addAll("Detské konto", "Konto pre dospelých", "Knihovník", "Skladník");
    }

    /**
     * new user registration button
     * @param actionEvent event that was started
     * @throws InterruptedException
     */
    public void registerButtonClick(ActionEvent actionEvent) throws InterruptedException {
        if (nameText.getText().equals("") || loginText.getText().equals("") || passText.getText().equals("") || comboBox.getSelectionModel().isEmpty()) {
            AlertSystem errorWindow = new AlertSystem("Pozor", "Nevyplnil si všetky údaje");
        }
        else {
            if (lib.getSysAcc().existUser(loginText.getText())) {
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
                    case ("Knihovník"): {
                        lib.getSysAcc().addNewUserWorker(nameText.getText(), loginText.getText(), passText.getText(), false);
                        break;
                    }
                    case ("Skladník"): {
                        lib.getSysAcc().addNewUserStocker(nameText.getText(), loginText.getText(), passText.getText(), false);
                        break;
                    }
                }
                AlertSystem errorWindow = new AlertSystem("Informácia", "Úcet vytvorený");
                lib.getSysReq().addNewAccountReq(lib.getSysAcc().findAccountName(nameText.getText()));
                lib.serializeOffice();
                switchScene("logInScene.fxml", actionEvent);
            }
        }

    }


    /**
     * going back button (to log in scene)
     * @param actionEvent event that was started
     */
    public void goBackButton(ActionEvent actionEvent) {
        switchScene("../View/logInScene.fxml", actionEvent);
    }

}
