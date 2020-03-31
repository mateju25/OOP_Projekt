package People;

import Products.*;
import Services.SimpleSystem;
import java.io.Serializable;
import java.util.LinkedList;

public class AdultReader implements Reader, Serializable {
    //atributes
    private final int dataId;
    private final String name;
    private LinkedList<Book> myBooks = new LinkedList<Book>();
    private LinkedList<Message> myMessages = new LinkedList<Message>();

    //constructor
    public AdultReader(int paId, String paName) {
        this.dataId = paId;
        this.name = paName;
    }

    //getters
    @Override
    public int getID() {
        return this.dataId;
    }
    @Override
    public LinkedList<Book> getMyBooks() {
        return this.myBooks;
    }
    @Override
    public LinkedList<Message> getMyMessages() {
        return this.myMessages;
    }
    @Override
    public String getName()
    {
        return this.name;
    }
    @Override
    public String getInfo()
    {
        return String.format("%4d - Zakaznik(Dospelý):  %s", this.dataId, this.name);
    }

    //setters
    @Override
    public void setMyBooks(LinkedList<Book> list) {
        this.myBooks = list;
    }

    //visitor accepter
    @Override
    public LinkedList accept(SimpleSystem v) {
        return v.getList(this);
    }

    //methods
    @Override
    public void addBook(Book paBook){
        this.myBooks.add(paBook);
    }
    @Override
    public void addMessage(Message m) {
        this.myMessages.add(m);
    }
    @Override
    public String startScene() {
        return "logOutSceneClient.fxml";
    }
    @Override
    public void readMessage() {
        myMessages = null;
    }
}



