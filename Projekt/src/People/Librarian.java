package People;

import Products.Book;
import Products.Account;
import Systems.SimpleSystem;

import java.io.Serializable;
import java.util.LinkedList;

public class Librarian implements Worker, Serializable {
    //atributes
    private final int dataId;
    private final String name;

    //constructor
    public Librarian(int dataId, String name) {
        this.dataId = dataId;
        this.name = name;
    }

    //getters
    @Override
    public int getID() {
        return 0;
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
    public String startScene() {
        return "logOutSceneLibrarian.fxml";
    }

}
