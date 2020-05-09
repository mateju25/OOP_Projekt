package people;

import systems.SimpleSystem;
import java.util.LinkedList;

/**
 * Basic interface for all workers and readers
 * @author Matej Delincak
 */
public interface Human {
    /**
     * @return name of person
     */
    String getName();

    /**
     * @return info about person in String
     */
    String getInfo();

    /**
     * @return returns ID of object
     */
    int getID();

    /**
     * Visitor pattern accepter
     * @param v system of the library
     * @return accepted system
     */
    LinkedList accept(SimpleSystem v);

    /**
     * @return filename of .fxml file for gui
     */
    String startScene();
}