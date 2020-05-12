package people;

import products.Book;
import products.Account;
import systems.AccountSystem;

/**
 * Person that logs as worker
 * @author Matej Delincak
 */
public abstract class Worker implements Human{
    /**
     * can reserve book which is passed as argument
     * @param paBook {@link Book}
     */
    public abstract void reserveBook(Book paBook);
    /**
     * can unreserve book which is passed as argument
     * @param paBook {@link Book}
     * @param owner owner of the {@link Account}
     */
    public abstract void unreserveBook(Book paBook, Account owner);

    /**
     * confirms new account
     * @param owner owner of the {@link Account}
     */
    public abstract void acceptNewAccount(Account owner);
    /**
     * rejects new account
     * @param owner owner of the {@link Account}
     */
    public abstract void declineNewAccount(AccountSystem sys, Account owner);
}
