package Library;

import People.Worker;
import Products.Book;
import Services.Account;

import java.io.Serializable;

public interface Request extends Serializable {
    String showMessage();
    Account getRequester();
    Book getWantedBook();
    void acceptRequest(Worker paAccepter);
    void declineRequest(String s);
}
