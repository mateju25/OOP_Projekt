package People;

import Products.Book;
import Services.SimpleSystem;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

public class Librarian implements Worker, Serializable {
    private final int workNumber;
    private final String name;

    public Librarian(int workNumber, String name) {
        this.workNumber = workNumber;
        this.name = name;
    }

    @Override
    public LinkedList accept(SimpleSystem v) {
        return v.getList(this);
    }


    public int getWorkNumber()
    {
        return workNumber;
    }
    public String getName()
    {
        return name;
    }

    public void reserveBook(Book paBook){
        paBook.setReserve(true);
    }
    public void unreserveBook(Book paBook){
        paBook.setReserve(false);
    }
    public String startScene() {
        return "logOutSceneLibrarian.fxml";
    }

    public String getInfo()
    {
        return String.format("%4d - Pracovnik: %s",(this).getWorkNumber(), (this).getName());
    }
}
