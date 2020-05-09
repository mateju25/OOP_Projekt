package gui.controllers;

import people.BookStocker;
import products.Product;
import systems.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * This controller provides handlers for basic scene for {@link BookStocker}
 */
public class LogOutControllerBookStocker extends SimpleController{
    @FXML
    private ListView plainText;
    @FXML
    private Label statusBar;
    @FXML
    private ChoiceBox kindOfBook;
    @FXML
    private TextField bookName;
    @FXML
    private TextField ISBN;
    @FXML
    private TextField numOfPages;


    //inicializacia tabulkoveho vypisu
    @FXML
    public void initialize() {
        plainText.setCellFactory(param -> new ListCell<Object>() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setText(null);
                } else {
                    setText(((Product) item).getInfo());
                }
            }
        });
    }

    /**
     * Sets test for status bar in the scene
     */
    public void setStatusBar()
    {
        statusBar.setText("  Prihlásený užívateľ: " + lib.getSysAcc().getCurrUser().getOwner().getName());
    }

    //stlacenie odhlasovacieho tlacidla
    @FXML
    private void logOutButtonClicked(ActionEvent event) throws InterruptedException {
        lib.serializeOffice();
        lib.getSysAcc().getCurrUser().userLogOut();
        switchScene("../View/logInScene.fxml", event);
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
    private void requestButton(ActionEvent event) {
        switchScene("../View/requestScene.fxml", event);
    }

    //vytvorenie knihy
    @FXML
    private void createBook(ActionEvent event) {
        if ((bookName.getText().equals("")) || (ISBN.getText().equals("")) || (numOfPages.getText().equals("")) || (kindOfBook.getSelectionModel().getSelectedItem() == null)) {
            AlertSystem alert = new AlertSystem("Pozor", "Zadaj všetky parametre pre vytvorenie knihy.");
        }
        else {
            switch ((String) kindOfBook.getSelectionModel().getSelectedItem()) {
                case ("Kniha pre dospelých"): {
                    lib.getSysBook().addNewAdultBook(((BookStocker) lib.getSysAcc().getCurrUser().getOwner()), bookName.getText(), Integer.parseInt(numOfPages.getText()), ISBN.getText());
                    break;
                }
                case ("Kniha pre deti"): {
                    lib.getSysBook().addNewChildBook(((BookStocker) lib.getSysAcc().getCurrUser().getOwner()), bookName.getText(), Integer.parseInt(numOfPages.getText()), ISBN.getText());
                    break;
                }
            }
        }
    }

}

