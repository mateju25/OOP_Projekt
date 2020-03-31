package People;

import Products.Book;
import Products.Account;

public interface Worker extends Human{
    void reserveBook(Book paBook);
    void unreserveBook(Book paBook, Account owner);

}
