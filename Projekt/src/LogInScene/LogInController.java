package LogInScene;

import Library.Office;
import Services.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        if(lib.findUser(".Matej", "x") == 1) {
       // if(lib.findUser(loginText.getText(), passText.getText()) == 1) {
            System.out.println("Uzivatel prihlaseny");
            //(lib.getActiveUser()).reserveBook(lib.getBook());
            FXMLLoader loader = new FXMLLoader((getClass().getResource(lib.getActiveUser().startScene())));
            Parent root = loader.load();
            LogOutController logOutController = loader.getController();
            logOutController.transferData(this.lib);
            Scene scene = new Scene(root);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        }
        else
        {
            System.out.println("Uzivatel neprihlaseny");
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

