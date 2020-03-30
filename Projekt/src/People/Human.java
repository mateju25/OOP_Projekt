package People;

import Products.Book;
import Products.Message;
import Services.SimpleSystem;

import java.util.LinkedList;

public interface Human {
    String getName();
    String startScene();
    String getInfo();
    int getID();
    LinkedList<Message> getMyMessages();

    LinkedList accept(SimpleSystem v);
}