package People;

import Services.SimpleSystem;

import java.io.IOException;
import java.util.LinkedList;

public interface Human {
    String getName();
    String startScene();
    String getInfo();
    LinkedList accept(SimpleSystem v);
}