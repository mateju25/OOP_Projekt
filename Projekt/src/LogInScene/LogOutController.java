package LogInScene;

import Library.BookRequest;
import Library.Office;
import People.Reader;
import Products.Book;
import Services.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class LogOutController extends SimpleController{
    @FXML
    private ListView plainText;
    @FXML
    private Label billText;

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
        lib.getSysAcc().getCurrUser().userLogOut();
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
        plainText.getItems().addAll(lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysAcc()));
    }

    @FXML
    private void showBooksButton(ActionEvent event) throws IOException {
        plainText.getItems().clear();
        plainText.getItems().addAll(lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysBook()));
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
        if (plainText.getSelectionModel().getSelectedItem() == null)
        {
            AlertSystem alertWindow = new AlertSystem("Pozor", "Nevybral si ziadnu knihu");
        }
        else {
            if (lib.getSysReq().existsReq((Book) plainText.getSelectionModel().getSelectedItem(), lib.getSysAcc().getCurrUser()) == false)
                lib.getSysReq().addReq(new BookRequest(lib.getSysBook().findBook(((Book) plainText.getSelectionModel().getSelectedItem()).getID()), lib.getSysAcc().getCurrUser()));
            else
            {
                AlertSystem alertWindow = new AlertSystem("Pozor", "Zadana poziadavka uz existuje");
            }
        }
    }

    @FXML
    private void myBookShow(ActionEvent event) throws IOException {
        if (((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyBooks() == null)
        {
            AlertSystem errorWindow = new AlertSystem("Informacia", "Zatial nevlastnis ziadne knihy");
        }
        else{
            plainText.getItems().clear();
            plainText.getItems().addAll(((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyBooks());
        }

    }
}

