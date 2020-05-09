package systems;

import products.*;
import people.Librarian;

import java.io.*;
import java.util.LinkedList;

/**
 * System that holds and manages requests in library
 * @author Matej Delincak
 */
public class RequestSystem extends SimpleSystem implements Serializable  {
    //atributes
    private int currReq = 0;
    private static int maxId = 0;

    /**
     * @return current request that needs to be processed
     */
    public Request getCurrRequest() {
        return ((LinkedList<Request>)list).get(currReq);
    }

    /**
     * funcion that returns list of accounts - possible only for {@link Librarian}
     * @param person {@link Librarian}
     * @return list of accounts in system
     */
    @Override
    public LinkedList getList(Librarian person) {
        return ((LinkedList<Request>)list);
    }

    /**
     * function cycles through all requests
     * @return next request based on index
     */
    public Request nextRequest() {
        if (currReq + 1 >= ((LinkedList<Request>)list).size())
            return null;
        else {
            currReq++;
            return ((LinkedList<Request>)list).get(currReq);
        }
    }

    /**
     * function set current request at the begin of request list
     * @return first request
     */
    public Request beginRequest() {
        currReq = 0;
        if (((LinkedList<Request>)list).size() > 0){
            return ((LinkedList<Request>)list).get(currReq);
        }
        else
            return null;
    }

    /**
     * function deletes current requesr that is worked with
     */
    public void deleteRequest() {
        ((LinkedList<Request>)list).remove(currReq);
        if(currReq != 0) currReq--;
    }

    /**
     * function controllers whether specific book request exists
     * @param paBook {@link Book}
     * @param paAcc {@link Account}
     * @return true if book request exists or false if not
     */
    public boolean existsBookReq(Book paBook, Account paAcc) {
        for (Request req : ((LinkedList<Request>)list))
        {
            if  ((((BookRequest)req).getWantedBook().equals(paBook)) && (req.getRequester().equals(paAcc))) return true;
        }
        return false;
    }

    /**
     * adds new book request into the system
     * @param paBook {@link Book}
     * @param paRequester {@link Account}
     */
    public void addNewBookReq(Book paBook, Account paRequester) {
        ((LinkedList<Request>)list).add(new BookRequest(maxId, paBook, paRequester));
        maxId++;
    }

    /**
     * adss new account request into the system
     * @param paRequester {@link Account}
     */
    public void addNewAccountReq(Account paRequester) {
        ((LinkedList<Request>)list).add(new AccountRequest(paRequester));
        maxId++;
    }

    /**
     * serializes request system into file "requests.out"
     */
    public void run() {
        try {
            serialize("requests.out");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
