package People;

import Products.Book;

public interface Worker extends Human{
    int getWorkNumber();
    void reserveBook(Book paBook);
    void unreserveBook(Book paBook);

}
