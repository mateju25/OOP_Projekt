package People;

import Products.Book;
import Products.Message;

import java.util.LinkedList;

public interface Reader extends Human {
    void addBook(Book paBook);
    void setMyBooks(LinkedList<Book> list);
    LinkedList<Book> getMyBooks();
    void addMessage(Message m);
}