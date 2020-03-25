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
        System.out.println("Kniha nemoze byt zarezervovana tymto uzivatelom");
        return 0;
    }

    @Override
    public int unreserveBook(Book paBook) {
        // TODO Auto-generated method stub
        paBook.unreserve();
        System.out.println("Kniha vratena");
        return 1;
    }

    @Override
    public Pane startScene(Office lib) throws IOException {
        // TODO Auto-generated method stub
        return FXMLLoader.load(getClass().getResource("secondscene.fxml"));
    }
}

