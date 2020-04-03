package Systems;

import Products.BookRequest;
import Products.Request;
import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Products.Account;
import Products.Book;

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
    public boolean existsReq(Book paBook, Account paAcc) {
        for (Request req : ((LinkedList<Request>)list))
        {
            if  ((req.getWantedBook().equals(paBook)) && (req.getRequester().equals(paAcc))) return true;
        }
        return false;
    }
    //prida novu poziadavku
    public void addNewBookReq(Book paBook, Account paRequester) {
        ((LinkedList<Request>)list).add(new BookRequest(maxId, paBook, paRequester));
        maxId++;
    }

    //serialization
    public void serialize() throws IOException {
        ObjectOutputStream outB = new ObjectOutputStream(new FileOutputStream("requests.out"));
        outB.writeObject(((LinkedList<Request>)list));
        outB.close();
    }
    public void deserialize() throws ClassNotFoundException, IOException {
        ObjectInputStream inC = new ObjectInputStream(new FileInputStream("requests.out"));
        list = (LinkedList<Request>)inC.readObject();
        inC.close();
    }
}
