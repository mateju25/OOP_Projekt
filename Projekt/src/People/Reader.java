package People;

import Products.Book;
import Products.Message;

import java.util.LinkedList;

public interface Reader extends Human {
    //getters
    LinkedList<Book> getMyBooks();
    LinkedList<Message> getMyMessages();
    //setters
    void setMyBooks(LinkedList<Book> list);
    //methods
    void addBook(Book paBook);
    void addMessage(Message m);
    void readMessage();
}