package People;

import Products.Book;

public interface Worker extends Human{
    int getWorkNumber();
    void setWorkNumber(int paNum);
    void reserveBook(Book paBook);
    void unreserveBook(Book paBook);

}
