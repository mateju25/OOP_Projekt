package Library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MultipleController {
    private Office lib = new Office();

    @FXML
    private Pane pane1;
    @FXML
    private TextField loginText;
    @FXML
    private TextField passText;

    @FXML
    private void logInButtonClicked(ActionEvent event) throws IOException {
        if(lib.findUser(loginText.getText(), passText.getText()) == 1) {
            System.out.println("Uzivatel prihlaseny");
            //(lib.getActiveUser()).reserveBook(lib.getBook());
            Pane root = FXMLLoader.load(getClass().getResource("secondscene.fxml"));
            pane1.getChildren().setAll(root);
        }
        else
        {
            System.out.println("Uzivatel neprihlaseny");
        }
    }

    @FXML
    private void logOutButtonClicked(ActionEvent event) throws IOException {

        System.out.println("Uzivatel odhlaseny");
        lib.getActiveUser().userLogOut();
        Pane root = FXMLLoader.load(getClass().getResource("logInScene.fxml"));
        pane1.getChildren().setAll(root);
    }
}

