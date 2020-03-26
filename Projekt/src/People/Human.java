package People;

import Products.Book;

import java.io.IOException;

public interface Human {
    String getName();
    void setName(String paName);
    public String startScene() throws IOException;
    public String getInfo();
}