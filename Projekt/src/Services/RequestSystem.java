package Services;

import Library.Request;
import LogInScene.SimpleController;
import Products.Book;

import java.io.*;
import java.util.LinkedList;

public class RequestSystem implements SimpleSystem  {
    private LinkedList<Request> listReq = new LinkedList<Request>();
    private int currReq = 0;

    public LinkedList<Request> getListReq() {
        return listReq;
    }
    public void setListReq(LinkedList<Request> listReq) {
        this.listReq = listReq;
    }

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
    public Request getCurrRequest() {
        return listReq.get(currReq);
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
    public void addReq(Request paReq) {
        listReq.add(paReq);
    }


    public void serialize() throws ClassNotFoundException, IOException {
        ObjectOutputStream outB = new ObjectOutputStream(new FileOutputStream("books.out"));
        outB.writeObject(listReq);
        outB.close();
    }
    public void deserialize() throws ClassNotFoundException, IOException {
        ObjectInputStream inC = new ObjectInputStream(new FileInputStream("requests.out"));
        listReq = (LinkedList<Request>)inC.readObject();
        inC.close();
    }
}
