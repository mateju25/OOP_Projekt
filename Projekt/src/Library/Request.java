package Library;

import People.Worker;
import Products.Book;
import Services.Account;

import java.io.Serializable;

public interface Request extends Serializable {
    //getters
    Account getRequester();
    Book getWantedBook();
    //methods
    String showMessage();
    void acceptRequest(Worker paAccepter);
    void declineRequest();
}
