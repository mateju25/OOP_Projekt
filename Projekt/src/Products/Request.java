package Products;

import People.Worker;

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
