package People;

import Products.Book;
import Products.Message;
import Services.SimpleSystem;

import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.LinkedList;

public class AdultReader implements Reader, Serializable {
    private int idNumber;
    private final String name;
    private final LinkedList<Book> myBooks = new LinkedList<Book>();
    private final LinkedList<Message> myMessages = new LinkedList<Message>();

    public AdultReader(int idNumber, String name) {
        this.idNumber = idNumber;
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

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    public int getIdNumber()
    {
        return idNumber;
    }
    public String getName()
    {
        return name;
    }

    public void addBook(Book paBook){
        myBooks.add(paBook);
    }

    @Override
    public void addMessage(String s) {
        myMessages.add(new Message(s));
    }

    public String startScene() {
        return "logOutSceneClient.fxml";
    }

    public String getInfo()
    {
        return String.format("%4d - Zakaznik(Dospely):  %s",(this).idNumber, (this).getName());
    }
}



