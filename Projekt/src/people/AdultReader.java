package people;

import products.*;
import systems.SimpleSystem;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Adult reader that has access to all books
 */
public class AdultReader extends Reader implements Serializable {
    private final int dataId;
    private final String name;

    /**
     * creates an adult reader
     * @param paId id of the user
     * @param paName name of the user
     */
    public AdultReader(int paId, String paName) {
        this.dataId = paId;
        this.name = paName;
    }

    /**
     * @return specific ID of reader
     */
    @Override
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
    public String getInfo()
    {
        return String.format("%4d - Zakazník(Dospelý):  %s", this.dataId, this.name);
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



