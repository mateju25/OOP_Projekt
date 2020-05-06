package products;

import people.Worker;

public class AccountRequest extends Request {
    //attributes
    private final Account requester;

    //constructor
    public AccountRequest(Account paAcc)
    {
        this.requester = paAcc;
    }

    @Override
    public Account getRequester() {
        return this.requester;
    }

    @Override
    public String getInfo() {
        return requester.getOwner().getName() + " požiadal o vytvorenie nového úctu. \n";
    }

    @Override
    public void acceptRequest(Worker paAccepter) {
        paAccepter.acceptNewAccount(this.requester);
    }

    @Override
    public void declineRequest() {

    }
}
