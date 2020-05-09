package people;

import products.Book;
import systems.SimpleSystem;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Book stocker extends librarian, can confirm requests and add new books
 */
public class BookStocker extends Librarian implements Serializable {
    /**
     * creates a new Book Stocker
     * @param dataId id of the worker
     * @param name name of the worker
     */
    public BookStocker(int dataId, String name) {
        super(dataId, name);
    }

    /**
     * adds book to collenction
     * @param paList list of books in the system
     * @param paBook {@link Book}
     */
    public void addBook(LinkedList<Book> paList, Book paBook) {
        paList.add(paBook);
    }

    /**
     * @return filename of .fxml file for gui
     */
    @Override
    public String startScene() {
        return "../View/logOutSceneBookStocker.fxml";
    }

    /**
     * visitor pattern
     * @return system that has access to
     */
    @Override
    public LinkedList accept(SimpleSystem v) {
        return v.getList(this);
    }

}