package Services;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

public interface SimpleSystem extends Serializable {
    //getters
    LinkedList getListAdmin();
    LinkedList getList(AdultReader person);
    LinkedList getList(ChildReader person);
    LinkedList getList(Librarian person);
    //serialization
    void serialize() throws IOException;
    void deserialize() throws ClassNotFoundException, IOException;
}
