package LogInScene;

import Library.Office;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {
    private Office lib = new Office();

    @FXML
    private TextField loginText;
    @FXML
    private TextField passText;

    @FXML
    private void logInButtonClicked(ActionEvent event) throws IOException {
        if(lib.findUser(loginText.getText(), passText.getText()) == 1) {
            System.out.println("Uzivatel prihlaseny");
            //(lib.getActiveUser()).reserveBook(lib.getBook());
            Pane root = FXMLLoader.load(getClass().getResource("../LogInScene/logOutScene.fxml"));
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


}

