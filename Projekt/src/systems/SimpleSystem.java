package systems;

import people.AdultReader;
import people.BookStocker;
import people.ChildReader;
import people.Librarian;

import java.io.*;
import java.util.LinkedList;

/**
 * Basic system in library that can do basic things of a system
 * @author Matej Delincak
 * @param <T> object that will be work with in system
 */
public abstract class SimpleSystem<T> implements Serializable, Runnable {
    /**
     * data list of object
     */
    protected LinkedList<T> list = new LinkedList<T>();

    /**
     * @return list of objects
     */
    public LinkedList<T> getListAdmin() {
        return list;
    }

    /**
     * this method must by overridden to add competency
     * @param person {@link AdultReader}
     * @return null because not admin
     */
    public LinkedList<T> getList(AdultReader person) {
        return null;
    }
    /**
     * this method must by overridden to add competency
     * @param person {@link ChildReader}
     * @return null because not admin
     */
    public LinkedList<T> getList(ChildReader person) {
        return null;
    }
    /**
     * this method must by overridden to add competency
     * @param person {@link Librarian}
     * @return null because not admin
     */
    public LinkedList<T> getList(Librarian person) {
        return null;
    }
    /**
     * this method must by overridden to add competency
     * @param person {@link BookStocker}
     * @return null because not admin
     */
    public LinkedList<T> getList(BookStocker person) {
        return null;
    }

    /**
     * serializes itself base on file name
     * @param paFileName name of the file
     * @throws IOException
     */
    public void serialize(String paFileName) throws IOException {
        ObjectOutputStream outB = new ObjectOutputStream(new FileOutputStream(paFileName));
        outB.writeObject(list);
        outB.close();
    }

    /**
     /**
     * deserializes itself base on file name
     * @param paFileName name of the file
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void deserialize(String paFileName) throws ClassNotFoundException, IOException {
        ObjectInputStream inB = new ObjectInputStream(new FileInputStream(paFileName));
        list = (LinkedList<T>)inB.readObject();
        inB.close();
    }
}
