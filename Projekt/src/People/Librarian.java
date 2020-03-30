package People;

import Products.Book;
import Products.Message;
import Services.SimpleSystem;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

public class Librarian implements Worker, Serializable {
    private final int dataId;
    private final String name;

    public Librarian(int dataId, String name) {
        this.dataId = dataId;
        this.name = name;
    }

    @Override
    public LinkedList accept(SimpleSystem v) {
        return v.getList(this);
    }


    public String getName()
    {
        return name;
    }

    public void reserveBook(Book paBook){
        paBook.setReserve(true);
    }
    public void unreserveBook(Book paBook){
        paBook.setReserve(false);
    }
    public String startScene() {
        return "logOutSceneLibrarian.fxml";
    }

    public String getInfo()
    {
        return String.format("%4d - Pracovnik: %s",(this).dataId, (this).getName());
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public LinkedList<Message> getMyMessages() {
        return null;
    }
}
