package systems;

import people.*;
import products.*;
import java.io.*;
import java.util.LinkedList;

/**
 * System that holds and manages books in library
 * @author Matej Delincak
 */
public class BookSystem extends SimpleSystem implements Serializable {
    //atributes
    private static int maxID = 0;

    /**
     * funcion that returns list of books - possible only for {@link AdultReader}
     * @param person {@link AdultReader}
     * @return list of books in system
     */
    @Override
    public LinkedList getList(AdultReader person) {

        return ((LinkedList<Book>)list);
    }

    /**
     * funcion that returns list of books available only for kids - possible only for  {@link ChildReader}
     * @param person {@link ChildReader}
     * @return list of books in system
     */
    @Override
    public LinkedList getList(ChildReader person) {
        LinkedList<Book> childBooks = new LinkedList<Book>();
        for (Book b : ((LinkedList<Book>)list)) {
            if(b instanceof ChildBook) childBooks.add(b);
        }
        return childBooks;
    }

    /**
     * funcion that returns list of books - possible only for  {@link Librarian}
     * @param person {@link Librarian}
     * @return list of books in system
     */
    @Override
    public LinkedList getList(Librarian person) {

        return ((LinkedList<Book>)list);
    }

    /**
     * funcion that returns list of books - possible only for  {@link BookStocker}
     * @param person {@link BookStocker}
     * @return list of books in system
     */
    @Override
    public LinkedList getList(BookStocker person) {

        return ((LinkedList<Book>)list);
    }

    /**
     * finds book based on its ID
     * @param paID id of the book
     * @return book with specific paID
     */
    public Book findBook(int paID) {
        for(Book book : ((LinkedList<Book>)list))
        {
            if (book.getID() == paID) return book;
        }
        return null;
    }

    /**
     * adds new child book into the system
     * @param creator {@link BookStocker}
     * @param title title of the book
     * @param pages number of the pages
     * @param ISBN isbn of the book
     * @param review review of the book
     */
    public void addNewChildBook(BookStocker creator, String title, String paAuthor, int pages, String ISBN, String review) {
        creator.addBook((LinkedList<Book>)list, new ChildBook(maxID, title, paAuthor, pages, ISBN, review));
        maxID++;
    }

    /**
     * adds new child book into the system
     * @param creator {@link BookStocker}
     * @param title title of the book
     * @param pages number of the pages
     * @param ISBN isbn of the book
     */
    public void addNewChildBook(BookStocker creator,String title, String paAuthor, int pages, String ISBN) {
        creator.addBook((LinkedList<Book>)list, new ChildBook(maxID, title, paAuthor, pages, ISBN));
        maxID++;
    }

    /**
     * adds new adult book into the system
     * @param creator {@link BookStocker}
     * @param title title of the book
     * @param pages number of the pages
     * @param ISBN isbn of the book
     * @param review review of the book
     */
    public void addNewAdultBook(BookStocker creator,String title, String paAuthor, int pages, String ISBN, String review)  {
        creator.addBook((LinkedList<Book>)list, new AdultBook(maxID, title, paAuthor, pages, ISBN, review));
        maxID++;
    }

    /**
     * adds new adult book into the system
     * @param creator {@link BookStocker}
     * @param title title of the book
     * @param pages number of the pages
     * @param ISBN isbn of the book
     */
    public void addNewAdultBook(BookStocker creator,String title, String paAuthor, int pages, String ISBN)  {
        creator.addBook((LinkedList<Book>)list, new AdultBook(maxID, title, paAuthor, pages, ISBN));
        maxID++;
    }

    /**
     * serializes book system into file "book.out"
     */
    public void run() {
        try {
            serialize("books.out");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
