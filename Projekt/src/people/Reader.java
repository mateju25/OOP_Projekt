package people;

import products.Account;
import products.Book;
import products.Message;

import java.util.LinkedList;

/**
 * Person that logs as reader
 * @author Matej Delincak
 */
public abstract class Reader implements Human {
    protected LinkedList<Book> myBooks = new LinkedList<Book>();
    protected LinkedList<Message> myMessages = new LinkedList<Message>();


    /**
     * @return list of books owned by person
     */
    public LinkedList<Book> getMyBooks() {
        return this.myBooks;
    }

    /**
     * @return list of messages owned by person
     */
    public LinkedList<Message> getMyMessages() {
        return this.myMessages;
    }

    /**
     * assignes books to specific person
     * @param list list of books
     */
    public void setMyBooks(LinkedList<Book> list) {
        this.myBooks = list;
    }

    /**
     * adds one new book to a person
     * @param paBook {@link Book}
     */
    public void addBook(Book paBook){
        this.myBooks.add(paBook);
    }

    /**
     * deletes books from the user
     * @param paBook {@link Book}
     */
    public void deleteBook(Book paBook){
        this.myBooks.remove(paBook);
    }

    /**
     * adds message to its list
     * @param m {@link Message}
     */
    public void addMessage(Message m) {
        this.myMessages.add(m);
    }

    /**
     * marks all the messages as read
     */
    public void readMessage() {
        myMessages = new LinkedList<Message>();
    }
}