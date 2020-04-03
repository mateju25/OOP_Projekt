package Systems;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Products.AdultBook;
import Products.Book;
import Products.ChildBook;
import Products.Request;

import java.io.*;
import java.util.LinkedList;

public class BookSystem extends SimpleSystem implements Serializable {
    //atributes
    private static int maxID = 0;

    //getters
    //vrati zoznam knih na zaklade ziadatela
    @Override
    public LinkedList getList(AdultReader person) {

        return ((LinkedList<Book>)list);
    }
    @Override
    public LinkedList getList(ChildReader person) {
        LinkedList<Book> childBooks = new LinkedList<Book>();
        for (Book b : ((LinkedList<Book>)list)) {
            if(b instanceof ChildBook) childBooks.add(b);
        }
        return childBooks;
    }
    @Override
    public LinkedList getList(Librarian person) {

        return ((LinkedList<Book>)list);
    }

    //methods
    public Book findBook(int paID) {
        for(Book book : ((LinkedList<Book>)list))
        {
            if (book.getID() == paID) return book;
        }
        return null;
    }
    public void addNewChildBook(String title, int pages, String ISBN, String review) {
        ((LinkedList<Book>)list).add(new ChildBook(maxID, title, pages, ISBN, review));
        maxID++;
    }
    public void addNewChildBook(String title, int pages, String ISBN) {
        ((LinkedList<Book>)list).add(new ChildBook(maxID, title, pages, ISBN));
        maxID++;
    }
    public void addNewAdultBook(String title, int pages, String ISBN, String review)  {
        ((LinkedList<Book>)list).add(new AdultBook(maxID, title, pages, ISBN, review));
        maxID++;
    }
    public void addNewAdultBook(String title, int pages, String ISBN)  {
        ((LinkedList<Book>)list).add(new AdultBook(maxID, title, pages, ISBN));
        maxID++;
    }

    //serialization
    public void serialize() throws IOException {
        ObjectOutputStream outB = new ObjectOutputStream(new FileOutputStream("books.out"));
        outB.writeObject(((LinkedList<Book>)list));
        outB.close();
    }
    public void deserialize() throws ClassNotFoundException, IOException {
        ObjectInputStream inB = new ObjectInputStream(new FileInputStream("books.out"));
        list = (LinkedList<Book>)inB.readObject();
        inB.close();
    }
}
