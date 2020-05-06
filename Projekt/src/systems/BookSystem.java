package systems;

import people.AdultReader;
import people.BookStocker;
import people.ChildReader;
import people.Librarian;
import products.AdultBook;
import products.Book;
import products.ChildBook;

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

    @Override
    public LinkedList getList(BookStocker person) {

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
    public void addNewChildBook(BookStocker creator, String title, int pages, String ISBN, String review) {
        creator.addBook((LinkedList<Book>)list, new ChildBook(maxID, title, pages, ISBN, review));
        maxID++;
    }
    public void addNewChildBook(BookStocker creator,String title, int pages, String ISBN) {
        creator.addBook((LinkedList<Book>)list, new ChildBook(maxID, title, pages, ISBN));
        maxID++;
    }
    public void addNewAdultBook(BookStocker creator,String title, int pages, String ISBN, String review)  {
        creator.addBook((LinkedList<Book>)list, new AdultBook(maxID, title, pages, ISBN, review));
        maxID++;
    }
    public void addNewAdultBook(BookStocker creator,String title, int pages, String ISBN)  {
        creator.addBook((LinkedList<Book>)list, new AdultBook(maxID, title, pages, ISBN));
        maxID++;
    }

    //serialization
    public void run() {
        //System.out.println("Book start");
        try {
            serialize("books.out");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Book end");
    }
}
