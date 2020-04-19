package Products;

import People.Worker;

public class AccountRequest implements Request {
    //attributes
    private Account requester;

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
    public String showMessage() {
        return requester.getOwner().getName() + " požiadal o vytvorenie nového účtu. \n";
    }

    @Override
    public void acceptRequest(Worker paAccepter) {
        paAccepter.acceptNewAccount(this.requester);
    }

    @Override
    public void declineRequest() {

    }
}
