package products;

import people.Worker;

import java.io.Serializable;

public abstract class Request implements Serializable, Product {
    //getters
    public abstract Account getRequester();
    //methods
    public abstract void acceptRequest(Worker paAccepter);
    public abstract void declineRequest();
}
