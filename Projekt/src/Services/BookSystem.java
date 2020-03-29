package Services;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Products.Book;
import Products.ChildBook;

import java.io.*;
import java.util.LinkedList;

public class BookSystem implements SimpleSystem {
    private LinkedList<Book> listBook = new LinkedList<Book>();

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

    public Book findBook(int paID) {
        for(Book book : listBook)
        {
            if (book.getID() == paID) return book;
        }
        return null;
    }
    public void addBook(Book paBook) {
        listBook.add(paBook);
    }



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
