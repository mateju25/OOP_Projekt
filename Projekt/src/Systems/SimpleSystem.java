package Systems;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Products.Book;

import java.io.*;
import java.util.LinkedList;

public abstract class SimpleSystem<T> implements Serializable, Runnable {
    //atributes
    protected LinkedList<T> list = new LinkedList<T>();

    //getters
    public LinkedList<T> getListAdmin() {
        return list;
    }
    public LinkedList<T> getList(AdultReader person) {
        return null;
    }
    public LinkedList<T> getList(ChildReader person) {
        return null;
    }
    public LinkedList<T> getList(Librarian person) {
        return null;
    }
    //serialization
    public void serialize(String paFileName) throws IOException {
        ObjectOutputStream outB = new ObjectOutputStream(new FileOutputStream(paFileName));
        outB.writeObject(((LinkedList<T>)list));
        outB.close();
    };
    public void deserialize(String paFileName) throws ClassNotFoundException, IOException {
        ObjectInputStream inB = new ObjectInputStream(new FileInputStream(paFileName));
        list = (LinkedList<T>)inB.readObject();
        inB.close();
    }
}
