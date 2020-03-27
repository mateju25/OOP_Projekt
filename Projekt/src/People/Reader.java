package People;

import Products.Book;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

public class Reader implements Client, Serializable {
    private int idNumber;
    private String name;
    private LinkedList<Book> myBooks = new LinkedList<Book>();

    public Reader(int idNumber, String name) {
        this.idNumber = idNumber;
        this.name = name;
    }

    public LinkedList<Book> getMyBooks() {
        return myBooks;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    public int getIdNumber()
    {
        return idNumber;
    };
    public String getName()
    {
        return name;
    };

    public void addBook(Book paBook){
        myBooks.add(paBook);
    };

    public String startScene() throws IOException {
        return "logOutSceneClient.fxml";
    };

    public String getInfo()
    {
        return String.format("%4d - Zakaznik:  %s",(this).idNumber, (this).getName());
    }
}
