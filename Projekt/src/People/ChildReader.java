package People;

import Products.Book;
import Products.Message;
import Services.SimpleSystem;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

public class ChildReader implements Reader, Serializable {
    private final int dataId;
    private final String name;
    private LinkedList<Book> myBooks = new LinkedList<Book>();
    private LinkedList<Message> myMessages = new LinkedList<Message>();

    public ChildReader(int idNumber, String name) {
        this.dataId = idNumber;
        this.name = name;
    }

    @Override
    public LinkedList accept(SimpleSystem v) {
        return v.getList(this);
    }
    public LinkedList<Book> getMyBooks() {
        return myBooks;
    }
    public LinkedList<Message> getMyMessages() {
        return myMessages;
    }

    @Override
    public void addMessage(Message m) {
        myMessages.add(m);
    }

    public String getName()
    {
        return name;
    }

    public void addBook(Book paBook){
        myBooks.add(paBook);
    }

    @Override
    public void setMyBooks(LinkedList<Book> list) {
        myBooks = list;
    }

    public String startScene() {
        return "logOutSceneClient.fxml";
    }

    public String getInfo()
    {
        return String.format("%4d - Zakaznik(Dieta):  %s",(this).dataId, (this).getName());
    }

    @Override
    public int getID() {
        return 0;
    }
}
