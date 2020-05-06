package people;

import products.Book;
import products.Message;

import java.util.LinkedList;

public abstract class Reader implements Human {
    //getters
    public abstract LinkedList<Book> getMyBooks();
    public abstract LinkedList<Message> getMyMessages();
    //setters
    public abstract void setMyBooks(LinkedList<Book> list);
    //methods
    public abstract void addBook(Book paBook);
    public abstract void deleteBook(Book paBook);
    public abstract void addMessage(Message m);
    public abstract void readMessage();
}