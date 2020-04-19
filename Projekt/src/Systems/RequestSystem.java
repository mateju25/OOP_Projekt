package Systems;

import Products.*;
import People.AdultReader;
import People.ChildReader;
import People.Librarian;

import java.io.*;
import java.util.LinkedList;

public class RequestSystem extends SimpleSystem implements Serializable  {
    //atributes
    private int currReq = 0;
    private static int maxId = 0;

    //getters
    public Request getCurrRequest() {
        return ((LinkedList<Request>)list).get(currReq);
    }
    //vrati zoznam poziadaviek na zaklade ziadatela
    @Override
    public LinkedList getList(Librarian person) {
        return ((LinkedList<Request>)list);
    }

    //methods for GUI
    //dalsia poziadavka v poradi
    public Request nextRequest() {
        if (currReq + 1 >= ((LinkedList<Request>)list).size())
            return null;
        else {
            currReq++;
            return ((LinkedList<Request>)list).get(currReq);
        }
    }
    //prva poziadavka v poradi
    public Request beginRequest() {
        currReq = 0;
        if (((LinkedList<Request>)list).size() > 0){
            return ((LinkedList<Request>)list).get(currReq);
        }
        else
            return null;
    }
    public void deleteRequest() {
        ((LinkedList<Request>)list).remove(currReq);
        if(currReq != 0) currReq--;
    }
    //vrati boolean ci existuje kniha
    public boolean existsBookReq(Book paBook, Account paAcc) {
        for (Request req : ((LinkedList<Request>)list))
        {
            if  ((((BookRequest)req).getWantedBook().equals(paBook)) && (req.getRequester().equals(paAcc))) return true;
        }
        return false;
    }
    //prida novu poziadavku
    public void addNewBookReq(Book paBook, Account paRequester) {
        ((LinkedList<Request>)list).add(new BookRequest(maxId, paBook, paRequester));
        maxId++;
    }
    //prida novu poziadavku
    public void addNewAccountReq(Account paRequester) {
        ((LinkedList<Request>)list).add(new AccountRequest(paRequester));
        maxId++;
    }

    //serialization
    public void run() {
        //System.out.println("Req start");
        try {
            serialize("requests.out");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Req end");
    }
}
