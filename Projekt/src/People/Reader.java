package People;

import Products.Book;

import java.util.LinkedList;

public interface Reader extends Human {
    LinkedList<Book> getMyBooks();
    void addBook(Book paBook);
}
