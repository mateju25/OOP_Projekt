package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import products.Account;
import products.Book;
import products.Product;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * This controller provides handlers for basic scene for {@link people.Librarian}
 */
public class LogOutControllerLibrarian extends SimpleController{
    @FXML
    private ListView plainText;
    @FXML
    private Label statusBar;

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

    //stlacenie odhlasovacieho tlacidla
    @FXML
    private void logOutButtonClicked(ActionEvent event) throws InterruptedException {
        lib.serializeOffice();
        lib.getSysAcc().getCurrUser().userLogOut();
        switchScene("../View/logInScene.fxml", event);
    }

    @FXML
    private void openDoc(ActionEvent event) throws InterruptedException, IOException {
        File htmlFile = new File("D:\\Skola\\2_semester\\OOP-projekt\\docs\\index.html");
        Desktop.getDesktop().browse(htmlFile.toURI());
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


}

