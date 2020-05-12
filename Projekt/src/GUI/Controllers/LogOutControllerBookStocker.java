package gui.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import people.BookStocker;
import products.Account;
import products.Book;
import products.Product;
import systems.AlertSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

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
    @FXML
    private TextField authorName;


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

    /**
     * Sets test for status bar in the scene
     */
    public void setStatusBar()
    {
        statusBar.setText("  Prihlásený užívateľ: " + lib.getSysAcc().getCurrUser().getOwner().getName());
    }

    @FXML
    private void openDoc(ActionEvent event) throws InterruptedException, IOException {
        File htmlFile = new File("D:\\Skola\\2_semester\\OOP-projekt\\docs\\index.html");
        Desktop.getDesktop().browse(htmlFile.toURI());
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
        if ((bookName.getText().equals("")) || (ISBN.getText().equals("")) || (authorName.getText().equals("")) || (numOfPages.getText().equals("")) || (kindOfBook.getSelectionModel().getSelectedItem() == null)) {
            AlertSystem alert = new AlertSystem("Pozor", "Zadaj všetky parametre pre vytvorenie knihy.");
        }
        else {
            switch ((String) kindOfBook.getSelectionModel().getSelectedItem()) {
                case ("Kniha pre dospelých"): {
                    lib.getSysBook().addNewAdultBook(((BookStocker) lib.getSysAcc().getCurrUser().getOwner()), bookName.getText(), authorName.getText(), Integer.parseInt(numOfPages.getText()), ISBN.getText());
                    break;
                }
                case ("Kniha pre deti"): {
                    lib.getSysBook().addNewChildBook(((BookStocker) lib.getSysAcc().getCurrUser().getOwner()), bookName.getText(), authorName.getText(), Integer.parseInt(numOfPages.getText()), ISBN.getText());
                    break;
                }
            }
        }
    }

}

