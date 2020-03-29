package Services;

import Library.Request;
import LogInScene.SimpleController;
import Products.Book;

import java.io.*;
import java.util.LinkedList;

public class BookSystem implements SimpleSystem {
    private LinkedList<Book> listBook = new LinkedList<Book>();

    public LinkedList<Book> getListBook() {
        return listBook;
    }
    public void setListBook(LinkedList<Book> listBook) {
        this.listBook = listBook;
    }

    public Book findBook(int paID) {
        for(Book book : listBook)
        {
            if (book.getID() == paID) return book;
        }
        return null;
    }
    public void addBook(Book paBook) {

    }



    public void serialize() throws ClassNotFoundException, IOException {
        ObjectOutputStream outB = new ObjectOutputStream(new FileOutputStream("books.out"));
        outB.writeObject(listBook);
        outB.close();
    }
    public void deserialize() throws ClassNotFoundException, IOException {
        ObjectInputStream inB = new ObjectInputStream(new FileInputStream("books.out"));
        listBook = (LinkedList<Book>)inB.readObject();
        inB.close();
    }
}
