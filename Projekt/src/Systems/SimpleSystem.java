package Systems;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

public abstract class SimpleSystem<T> implements Serializable {
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
    public abstract void serialize() throws IOException;
    public abstract void deserialize() throws ClassNotFoundException, IOException;
}
