package People;

import Products.Book;

import java.io.IOException;
import java.io.Serializable;

public class Reader implements Client, Serializable {
    private int idNumber;
    private String name;

    public int getIdNumber()
    {
        return idNumber;
    };
    public void setIdNumber(int paNum)
    {
        idNumber = paNum;
    };
    public String getName()
    {
        return name;
    };
    public void setName(String paName)
    {
        name = paName;
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
