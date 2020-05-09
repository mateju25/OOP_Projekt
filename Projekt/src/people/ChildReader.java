package people;

import systems.SimpleSystem;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Child reader that has access only to some kind of books
 */
public class ChildReader extends Reader implements Serializable {
    private final int dataId;
    private final String name;

    /**
     * creates a child reader
     * @param paId id of the user
     * @param paName name of the user
     */
    public ChildReader(int paId, String paName) {
        this.dataId = paId;
        this.name = paName;
    }

    /**
     * @return specific ID of reader
     */
    public int getID() {
        return this.dataId;
    }

    /**
     * @return name of the person
     */
    @Override
    public String getName()
    {
        return this.name;
    }

    /**
     * @return info about a reader
     */
    @Override
    public String getInfo() {
        return String.format("%4d - Zakaznik(Dieta):  %s", (this).dataId, (this).getName());
    }


    /**
     * visitor pattern
     * @return system that has access to
     */
    @Override
    public LinkedList accept(SimpleSystem v) {
        return v.getList(this);
    }

    /**
     * @return filename of .fxml file for gui
     */
    @Override
    public String startScene() {
        return "../View/logOutSceneClient.fxml";
    }
}
