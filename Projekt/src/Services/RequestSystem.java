package Services;

import Library.BookRequest;
import Library.Request;
import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Products.Book;

import java.io.*;
import java.util.LinkedList;

public class RequestSystem implements SimpleSystem, Serializable  {
    //atributes
    private LinkedList<Request> listReq = new LinkedList<Request>();
    private int currReq = 0;
    private static int maxId = 0;

    //getters
    public Request getCurrRequest() {
        return listReq.get(currReq);
    }
    @Override
    public LinkedList getListAdmin() {
        return listReq;
    }
    @Override
    public LinkedList getList(AdultReader person) {
        return null;
    }
    @Override
    public LinkedList getList(ChildReader person) {
        return null;
    }
    @Override
    public LinkedList getList(Librarian person) {
        return listReq;
    }

    //methods for GUI
    public Request nextRequest() {
        if (currReq + 1 >= listReq.size())
            return null;
        else {
            currReq++;
            return listReq.get(currReq);
        }
    }
    public Request beginRequest() {
        currReq = 0;
        if (listReq.size() > 0){
            return listReq.get(currReq);
        }
        else
            return null;
    }
    public void deleteRequest() {
        listReq.remove(currReq);
        if(currReq != 0) currReq--;
    }
    public boolean existsReq(Book paBook, Account paAcc) {
        for (Request req : listReq)
        {
            if  ((req.getWantedBook().equals(paBook)) && (req.getRequester().equals(paAcc))) return true;
        }
        return false;
    }
    public void addNewBookReq(Book paBook, Account paRequester) {
        listReq.add(new BookRequest(maxId, paBook, paRequester));
        maxId++;
    }

    //serialization
    public void serialize() throws IOException {
        ObjectOutputStream outB = new ObjectOutputStream(new FileOutputStream("requests.out"));
        outB.writeObject(listReq);
        outB.close();
    }
    public void deserialize() throws ClassNotFoundException, IOException {
        ObjectInputStream inC = new ObjectInputStream(new FileInputStream("requests.out"));
        listReq = (LinkedList<Request>)inC.readObject();
        inC.close();
    }
}
