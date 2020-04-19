package gui;

import People.Reader;
import People.Worker;
import Products.Account;
import Products.Book;
import Products.Message;
import Systems.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class LogOutController extends SimpleController{
    @FXML
    private ListView plainText;
    @FXML
    private Label newMessagesText;
    @FXML
    private Label statusBar;
    @FXML
    private Button markButton;

    //nastavi oznam o novych sprav
    public void setMessText()
    {
        if (((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages() == null)
            newMessagesText.setText("Nové správy: " + 0);
        else
            if (((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages().size() != 0)
                newMessagesText.setText("Nové správy: " + ((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages().size());
            else
                newMessagesText.setText("Nové správy: " + 0);

        setStatusBar();
    }

    public void setStatusBar()
    {
        statusBar.setText("  Prihlásený užívateľ: " + lib.getSysAcc().getCurrUser().getOwner().getName());
    }

    //inicializacia tabulkoveho vypisu
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

    //stlacenie odhlasovacieho tlacidla
    @FXML
    private void logOutButtonClicked(ActionEvent event) throws InterruptedException {
        lib.serializeOffice();
        lib.getSysAcc().getCurrUser().userLogOut();
        switchScene("logInScene.fxml", event);
    }
    //zobraz ucty
    @FXML
    private void showAccountsButton(ActionEvent event) {
        plainText.getItems().clear();
        plainText.getItems().addAll(lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysAcc()));
    }
    //zobraz knihy
    @FXML
    private void showBooksButton(ActionEvent event) {
        plainText.getItems().clear();
        plainText.getItems().addAll(lib.getSysAcc().getCurrUser().getOwner().accept(lib.getSysBook()));
    }
    //prepnutie sceny
    @FXML
    private void requestButton(ActionEvent event) throws IOException {
        switchScene("requestScene.fxml", event);
    }
    //vytvorenie novej poziadavky
    @FXML
    private void makeNewRequest(ActionEvent event) {
        if (plainText.getSelectionModel().getSelectedItem() == null)
        {
            AlertSystem alertWindow = new AlertSystem("Pozor", "Nevybral si žiadnu knihu");
        }
        else {
            if (!lib.getSysReq().existsBookReq((Book) plainText.getSelectionModel().getSelectedItem(), lib.getSysAcc().getCurrUser()))
                lib.getSysReq().addNewBookReq(lib.getSysBook().findBook(((Book) plainText.getSelectionModel().getSelectedItem()).getID()), lib.getSysAcc().getCurrUser());
            else
            {
                AlertSystem alertWindow = new AlertSystem("Pozor", "Zadana požiadavka už existuje");
            }
        }
    }

    //vratenie knihy
    @FXML
    private void giveBookBack(ActionEvent event) {
        if (plainText.getSelectionModel().getSelectedItem() == null)
        {
            AlertSystem alertWindow = new AlertSystem("Pozor", "Nevybral si žiadnu knihu");
        }
        else {
            ((Worker)lib.getSysAcc().getFirstWorker().getOwner()).unreserveBook((Book) plainText.getSelectionModel().getSelectedItem(), lib.getSysAcc().getCurrUser());
            myBookShow(event);
        }
    }

    //zobraz nove spravy
    @FXML
    private void showNewMessages(ActionEvent event) {
        if (((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages() == null) return;
        for (Message m : ((Reader)lib.getSysAcc().getCurrUser().getOwner()).getMyMessages()) {
            AlertSystem alertWindow = new AlertSystem("Nová správa", m.getInfo());
        }
        markButton.setDisable(false);
    }

    //zobraz moje knihy
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

    //zobraz recenziiu oznacenej knihy
    @FXML
    private void showReviews(ActionEvent event) {
        if (plainText.getSelectionModel().getSelectedItem() == null)
        {
            AlertSystem alertWindow = new AlertSystem("Pozor", "Nevybral si žiadnu knihu");
        }
        else {
            AlertSystem alertWindow;
            if (((Book) plainText.getSelectionModel().getSelectedItem()).getReview() == null)
                alertWindow = new AlertSystem("Informácia", "Táto kniha nemá recenziu.");
            else
                alertWindow = new AlertSystem("Informácia", ((Book) plainText.getSelectionModel().getSelectedItem()).getReview());
        }
    }

    //oznaci spravy ako precitane
    @FXML
    private void markAsRead(ActionEvent event) throws InterruptedException {
        ((Reader)lib.getSysAcc().getCurrUser().getOwner()).readMessage();
        setMessText();
        markButton.setDisable(true);
        lib.serializeOffice();
    }

}

