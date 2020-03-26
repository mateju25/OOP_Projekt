package LogInScene;

import Library.BookRequest;
import Library.Office;
import Products.Book;
import Services.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class LogOutController {
    private Office lib;

    @FXML
    private ListView plainText;
    @FXML
    private TextField enterIDText;

    @FXML
    public void initialize() {
        plainText.setCellFactory(param -> new ListCell<Object>() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null) {
                        setText(null);
                    } else if (item instanceof Account) {
                        setText(((Account) item).getOwner().getInfo());
                    } else {
                        setText(((Book) item).getInfo());
                    }
                }
        });

    }

    @FXML
    private void logOutButtonClicked(ActionEvent event) throws IOException
    {
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
        plainText.getItems().clear();
        plainText.getItems().addAll(lib.getAccounts());
    }

    @FXML
    private void showBooksButton(ActionEvent event) throws IOException {
        plainText.getItems().clear();
        plainText.getItems().addAll(lib.getBooks());
    }

    @FXML
    private void requestButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader((getClass().getResource("requestScene.fxml")));
        Parent root = loader.load();
        RequestController logInController = loader.getController();
        logInController.transferData(this.lib);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    private void makeNewRequest(ActionEvent event) throws IOException {
        lib.createRequest(new BookRequest(lib.findBook(((Book)plainText.getSelectionModel().getSelectedItem()).getID()), lib.getActiveUser()));
    }

    public void transferData(Office paLib)
    {
        this.lib = paLib;
    }


}

