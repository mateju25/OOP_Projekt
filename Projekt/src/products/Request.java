package products;

import people.Worker;
import systems.AccountSystem;

import java.io.Serializable;

/**
 * simple request object
 * @author Matej Delincak
 */
public abstract class Request implements Serializable, Product {
    /**
     * @return requester of demand
     */
    public abstract Account getRequester();

    /**
     * accepts request by {@link Worker}
     * @param paAccepter {@link Worker}
     */
    public abstract void acceptRequest(Worker paAccepter);

    /**
     * declines request by {@link Worker}
     * @param paAccepter {@link Worker}
     */
    public abstract void declineRequest(AccountSystem sys, Worker paAccepter);
}
