package People;

import Products.Message;
import Services.SimpleSystem;

import java.util.LinkedList;

public interface Human {
    String getName();
    String startScene();
    String getInfo();
    LinkedList<Message> getMyMessages();
    LinkedList accept(SimpleSystem v);
}