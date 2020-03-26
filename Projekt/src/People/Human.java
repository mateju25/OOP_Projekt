package People;

import Products.Book;

import java.io.IOException;

public interface Human {
    String getName();
    public String startScene() throws IOException;
    public String getInfo();
}