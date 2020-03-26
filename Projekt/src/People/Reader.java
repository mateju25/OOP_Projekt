package People;

import Products.Book;

import java.io.IOException;
import java.io.Serializable;

public class Reader implements Client, Serializable {
    private int idNumber;
    private String name;

    public Reader(int idNumber, String name) {
        this.idNumber = idNumber;
        this.name = name;
    }

    public int getIdNumber()
    {
        return idNumber;
    };
    public String getName()
    {
        return name;
    };

    public void reserveBook(Book paBook){};
    public void unreserveBook(Book paBook){};
    public String startScene() throws IOException {
        return "logOutSceneClient.fxml";
    };

    public String getInfo()
    {
        return String.format("%4d - Zakaznik: %s",(this).idNumber, (this).getName());
    }
}
