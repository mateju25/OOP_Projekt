package people;

import products.Book;
import products.Account;
import systems.SimpleSystem;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Librarian extends basic worker, can confirm requests
 */
public class Librarian extends Worker implements Serializable {
    //atributes
    protected final int dataId;
    protected final String name;

    /**
     * create a new librarian
     * @param dataId Id of worker
     * @param name name of the user
     */
    public Librarian(int dataId, String name) {
        this.dataId = dataId;
        this.name = name;
    }

    /**
     *
     * @return specific ID
     */
    @Override
    public int getID() {
        return this.dataId;
    }
    /**
     * @return info about librarian
     */
    @Override
    public String getInfo()
    {
        return String.format("%4d - Pracovnik: %s",(this).dataId, (this).getName());
    }

    /**
     * @return info name of person
     */
    @Override
    public String getName() { return name;    }

    /**
     * visitor pattern
     * @return system that has access to
     */
    @Override
    public LinkedList accept(SimpleSystem v) {
        return v.getList(this);
    }

    /**
     * can reserve book
     * @param paBook {@link Book}
     */
    @Override
    public void reserveBook(Book paBook){
        paBook.setReserve(true);
    }
    /**
     * can unreserve book
     * @param paBook {@link Book}
     */
    @Override
    public void unreserveBook(Book paBook, Account owner){
        paBook.setReserve(false);
        ((Reader)owner.getOwner()).deleteBook(paBook);
    }

    /**
     * can accept new account
     * @param owner owner of the {@link Account}
     */
    @Override
    public void acceptNewAccount(Account owner) {
        owner.setVerified(true);
    }

    /**
     * can decline new account
     * @param owner owner of the {@link Account}
     */
    @Override
    public void declineNewAccount(Account owner) {
        owner.setVerified(false);
    }

    /**
     * @return filename of .fxml file for gui
     */
    @Override
    public String startScene() {
        return "../View/logOutSceneLibrarian.fxml";
    }

}
