package People;

import Products.Book;

import java.io.IOException;
import java.io.Serializable;

public class Librarian implements Worker, Serializable {
    private int workNumber;
    private String name;

    public Librarian(int workNumber, String name) {
        this.workNumber = workNumber;
        this.name = name;
    }

    public int getWorkNumber()
    {
        return workNumber;
    };
    public String getName()
    {
        return name;
    };

    public void reserveBook(Book paBook){
        paBook.setReserve(true);
    };
    public void unreserveBook(Book paBook){
        paBook.setReserve(false);
    };
    public String startScene() throws IOException{
        return "logOutSceneLibrarian.fxml";
    };

    public String getInfo()
    {
        return String.format("%4d - Pracovnik: %s",(this).getWorkNumber(), (this).getName());
    }
}
