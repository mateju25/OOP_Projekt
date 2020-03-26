package Library;

import Products.Book;
import Services.Account;

public interface Request {
    String showMessage();
    Account getRequester();
    Book getWantedBook();
    void acceptRequest();
    //void declineRequest();
}
