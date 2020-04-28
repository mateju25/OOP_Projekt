package People;

import Products.Account;
import Products.Book;
import Systems.SimpleSystem;

import java.io.Serializable;
import java.util.LinkedList;

public class BookStocker extends Librarian implements Serializable {
    //constructor
    public BookStocker(int dataId, String name) {
        super(dataId, name);
    }

    public void addBook(LinkedList<Book> paList, Book paBook) {
        paList.add(paBook);
    }

    @Override
    public String startScene() {
        return "logOutSceneBookStocker.fxml";
    }

}