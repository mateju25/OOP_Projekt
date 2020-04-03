package People;

import Products.Book;
import Products.Account;

public abstract class Worker implements Human{
    public abstract void reserveBook(Book paBook);
    public abstract void unreserveBook(Book paBook, Account owner);

}
