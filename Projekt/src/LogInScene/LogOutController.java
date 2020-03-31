package LogInScene;

import People.Reader;
import Products.Book;
import Products.Message;
import Services.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class LogOutController extends SimpleController{
    @FXML
    private ListView plainText;
    @FXML
    private Label billText;
    @FXML
    private Label newMessagesText;

    public void setMessText()
    {
        if (((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages() == null)
            newMessagesText.setText("Nové správy: " + 0);
        else
            if (((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages().size() != 0)
                newMessagesText.setText("Nové správy: " + ((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages().size());
            else
                newMessagesText.setText("Nové správy: " + 0);
    }

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
        switchScene("logInScene.fxml", event);
    }
    @FXML
    private void showAccountsButton(ActionEvent event) {
        plainText.getItems().clear();
        plainText.getItems().addAll(lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysAcc()));
    }

    @FXML
    private void showBooksButton(ActionEvent event) {
        plainText.getItems().clear();
        plainText.getItems().addAll(lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysBook()));
    }

    @FXML
    private void requestButton(ActionEvent event) throws IOException {
        switchScene("requestScene.fxml", event);
    }

    @FXML
    private void makeNewRequest(ActionEvent event) {
        if (plainText.getSelectionModel().getSelectedItem() == null)
        {
            AlertSystem alertWindow = new AlertSystem("Pozor", "Nevybral si žiadnu knihu");
        }
        else {
            if (!lib.getSysReq().existsReq((Book) plainText.getSelectionModel().getSelectedItem(), lib.getSysAcc().getCurrUser()))
                lib.getSysReq().addNewBookReq(lib.getSysBook().findBook(((Book) plainText.getSelectionModel().getSelectedItem()).getID()), lib.getSysAcc().getCurrUser());
            else
            {
                AlertSystem alertWindow = new AlertSystem("Pozor", "Zadana požiadavka už existuje");
            }
        }
    }

    @FXML
    private void showNewMessages(ActionEvent event) {
        if (((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages() == null) return;
        for (Message m : ((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages()) {
            AlertSystem alertWindow = new AlertSystem("Nová správa", m.getInfo());
        }
    }


    @FXML
    private void myBookShow(ActionEvent event) {
        if (((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyBooks() == null)
        {
            AlertSystem errorWindow = new AlertSystem("Informácia", "Zatiaľ nevlastníš žiadne knihy");
        }
        else{
            plainText.getItems().clear();
            plainText.getItems().addAll(((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyBooks());
        }
    }

    @FXML
    private void markAsRead(ActionEvent event) {
        ((Reader)lib.getSysAcc().getCurrUser().getOwner()).readMessage();
        setMessText();
    }

}

