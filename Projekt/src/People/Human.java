package People;

import Services.SimpleSystem;

import java.io.IOException;
import java.util.LinkedList;

public interface Human {
    String getName();
    public String startScene() throws IOException;
    public String getInfo();
    LinkedList accept(SimpleSystem v);
}