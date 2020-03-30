package People;

import Products.Book;

public interface Worker extends Human{
    void reserveBook(Book paBook);
    void unreserveBook(Book paBook);

}
