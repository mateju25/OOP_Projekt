package People;

import Products.Book;
import Products.Account;
import Systems.SimpleSystem;

import java.io.Serializable;
import java.util.LinkedList;

public class Librarian extends Worker implements Serializable {
    //atributes
    protected final int dataId;
    protected final String name;

    //constructor
    public Librarian(int dataId, String name) {
        this.dataId = dataId;
        this.name = name;
    }

    //getters
    @Override
    public int getID() {
        return this.dataId;
    }
    @Override
    public String getInfo()
    {
        return String.format("%4d - Pracovnik: %s",(this).dataId, (this).getName());
    }
    @Override
    public String getName()
    {
        return name;
    }

    //visitor accepter
    @Override
    public LinkedList accept(SimpleSystem v) {
        return v.getList(this);
    }

    //methods
    @Override
    public void reserveBook(Book paBook){
        paBook.setReserve(true);
    }
    @Override
    public void unreserveBook(Book paBook, Account owner){
        paBook.setReserve(false);
        ((Reader)owner.getOwner()).deleteBook(paBook);
    }

    @Override
    public void acceptNewAccount(Account owner) {
        owner.setVerified(true);
    }

    @Override
    public void declineNewAccount(Account owner) {
        owner.setVerified(false);
    }

    @Override
    public String startScene() {
        return "logOutSceneLibrarian.fxml";
    }

}
