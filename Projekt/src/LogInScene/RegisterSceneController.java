package LogInScene;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Services.Account;
import Services.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void registerButtonClick(ActionEvent actionEvent) {
        if (nameText.getText().equals("") || loginText.getText().equals("") || passText.getText().equals("") || comboBox.getSelectionModel().isEmpty()) {
            AlertSystem errorWindow = new AlertSystem("Pozor", "Nevyplnil si všetky údaje");
        }
        else {
            if (lib.getSysAcc().findUser(loginText.getText())) {
                AlertSystem errorWindow = new AlertSystem("Pozor", "Už existuje používateľ s rovnakým menom");
            }
            else {
                Account acc = null;
                switch ((String) comboBox.getSelectionModel().getSelectedItem()) {
                    case ("Detské konto"): {
                        acc = new Account(new ChildReader(lib.getSysAcc().countOfUsers(), nameText.getText()), loginText.getText(), passText.getText());
                        break;
                    }
                    case ("Konto pre dospelých"): {
                        acc = new Account(new AdultReader(lib.getSysAcc().countOfUsers(), nameText.getText()), loginText.getText(), passText.getText());
                        break;
                    }
                    case ("Konto pre pracovníkov"): {
                        acc = new Account(new Librarian(lib.getSysAcc().countOfUsers(), nameText.getText()), loginText.getText(), passText.getText());
                        break;
                    }
                }
                lib.getSysAcc().addUser(acc);

                AlertSystem errorWindow = new AlertSystem("Informácia", "Účet vytvorený");

                FXMLLoader loader = new FXMLLoader((getClass().getResource("logInScene.fxml")));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                LogInController logInController = loader.getController();
                logInController.transferData(this.lib);
                Scene scene = new Scene(root);

                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                window.setScene(scene);
                window.show();
            }
        }

    }

}
