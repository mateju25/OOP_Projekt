package Services;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Products.AdultBook;
import Products.Book;
import Products.ChildBook;

import java.io.*;
import java.util.LinkedList;

public class BookSystem implements SimpleSystem, Serializable {
    //atributes
    private LinkedList<Book> listBook = new LinkedList<Book>();
    private static int maxID = 0;

    //getters
    @Override
    public LinkedList getListAdmin() {
        return listBook;
    }
    @Override
    public LinkedList getList(AdultReader person) {

        return listBook;
    }
    @Override
    public LinkedList getList(ChildReader person) {
        LinkedList<Book> childBooks = new LinkedList<Book>();
        for (Book b : listBook) {
            if(b instanceof ChildBook) childBooks.add(b);
        }
        return childBooks;
    }
    @Override
    public LinkedList getList(Librarian person) {

        return listBook;
    }

    //methods
    public Book findBook(int paID) {
        for(Book book : listBook)
        {
            if (book.getID() == paID) return book;
        }
        return null;
    }
    public void addNewChildBook(String title, int pages, String ISBN) {
        listBook.add(new ChildBook(maxID, title, pages, ISBN));
        maxID++;
    }
    public void addNewAdultBook(String title, int pages, String ISBN)  {
        listBook.add(new AdultBook(maxID, title, pages, ISBN));
        maxID++;
    }

    //serialization
    public void serialize() throws IOException {
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
