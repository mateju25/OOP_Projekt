package Services;

import Library.Office;
import People.Human;
import Products.Book;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class ChildrenAccount extends Account{
    public ChildrenAccount(Human paNewOwner)
    {
        super(paNewOwner);
        bill = 0;
    }

    @Override
    public int reserveBook(Book paBook) {
        // TODO Auto-generated method stub
        if (paBook.isReserved() == true)
            System.out.println("Kniha nemoze byt zarezervovana tymto uzivatelom");
        else
        {
            paBook.setReserve(true);
            System.out.println("Kniha zarezervovana tymto uzivatelom");
        }
        return 0;
    }

    @Override
    public int unreserveBook(Book paBook) {
        // TODO Auto-generated method stub
        paBook.setReserve(false);
        System.out.println("Kniha vratena");
        return 1;
    }

    @Override
    public String startScene() throws IOException {
        return "logOutSceneClient.fxml";
    }
}

