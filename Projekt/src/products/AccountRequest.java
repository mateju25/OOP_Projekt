package products;

import people.Worker;

/**
 * Account request when registration of new user occurs
 * @author Matej Delincak
 */
public class AccountRequest extends Request {
    //attributes
    private final Account requester;

    /**
     * creates account request and paAcc will be its requester
     * @param paAcc {@link Account}
     */
    public AccountRequest(Account paAcc)
    {
        this.requester = paAcc;
    }

    /**
     * @return requester of this account request
     */
    @Override
    public Account getRequester() {
        return this.requester;
    }

    /**
     * @return info about account request
     */
    @Override
    public String getInfo() {
        return requester.getOwner().getName() + " požiadal o vytvorenie nového úctu. \n";
    }

    /**
     * accept account request, accepter {@link Worker}
     * @param paAccepter {@link Worker}
     */
    @Override
    public void acceptRequest(Worker paAccepter) {
        paAccepter.acceptNewAccount(this.requester);
    }

    /**
     * declines account request, decliner {@link Worker}
     * @param paAccepter {@link Worker}
     */
    @Override
    public void declineRequest(Worker paAccepter)  {
        paAccepter.declineNewAccount(this.requester);
    }
}
