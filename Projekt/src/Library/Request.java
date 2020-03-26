package Library;

import People.Worker;
import Products.Book;
import Services.Account;

public interface Request {
    String showMessage();
    Account getRequester();
    Book getWantedBook();
    void acceptRequest(Worker paAccepter);
    //void declineRequest();
}
