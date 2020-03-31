package People;

import Services.SimpleSystem;
import java.util.LinkedList;

public interface Human {
    //getters
    String getName();
    String getInfo();
    int getID();

    //visitor
    LinkedList accept(SimpleSystem v);
    //GUI
    String startScene();
}