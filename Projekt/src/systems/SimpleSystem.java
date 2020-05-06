package systems;

import people.AdultReader;
import people.BookStocker;
import people.ChildReader;
import people.Librarian;

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
    public LinkedList<T> getList(BookStocker person) {
        return null;
    }
    //serialization
    public void serialize(String paFileName) throws IOException {
        ObjectOutputStream outB = new ObjectOutputStream(new FileOutputStream(paFileName));
        outB.writeObject(list);
        outB.close();
    }
    public void deserialize(String paFileName) throws ClassNotFoundException, IOException {
        ObjectInputStream inB = new ObjectInputStream(new FileInputStream(paFileName));
        list = (LinkedList<T>)inB.readObject();
        inB.close();
    }
}
