package LogInScene;

import Library.Office;
import Products.Book;
import Services.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogOutController {
    private Office lib;

    @FXML
    private TextArea plainText;

    @FXML
    private void logOutButtonClicked(ActionEvent event) throws IOException {

        System.out.println("Uzivatel odhlaseny");
        lib.getActiveUser().userLogOut();
        FXMLLoader loader = new FXMLLoader((getClass().getResource("logInScene.fxml")));
        Parent root = loader.load();
        LogInController logInController = loader.getController();
        logInController.transferData(this.lib);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(new Scene(root));
        window.show();
    }
    @FXML
    private void showAccountsButton(ActionEvent event) throws IOException {
        System.out.println("Uzivatel vyhladal vsetky ucty");
        plainText.clear();
        for(Account a : lib.getAccounts()) {
            plainText.appendText(a.getOwner().getName() + "\n");
        }
    }

    @FXML
    private void showBooksButton(ActionEvent event) throws IOException {
        System.out.println("Uzivatel vyhladal vsetky knihy");
        plainText.clear();
        for(Book a : lib.getBooks()) {
            plainText.appendText(a.getID() + ": " + a.getTitle() + "\n");

        }
    }

    public void transferData(Office paLib)
    {
        this.lib = paLib;
    }
}

