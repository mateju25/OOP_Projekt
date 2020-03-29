package Services;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;

import java.io.IOException;
import java.util.LinkedList;

public interface SimpleSystem {
    LinkedList getList(AdultReader person);
    LinkedList getList(ChildReader person);
    LinkedList getList(Librarian person);
    void serialize() throws IOException;
    void deserialize() throws ClassNotFoundException, IOException;
}
