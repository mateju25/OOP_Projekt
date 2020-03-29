package Library;

import People.Reader;
import People.Worker;
import Products.Book;
import Services.Account;

public class BookRequest implements Request {
    private final Book wantedBook;
    private final Account requester;

    public Account getRequester() {
        return requester;
    }
    public Book getWantedBook() {
        return wantedBook;
    }

    public BookRequest(Book paBook, Account paRequester)
    {
        this.wantedBook = paBook;
        this.requester = paRequester;
    }

    @Override
    public String showMessage() {
        return requester.getOwner().getName() + " poziadal o knihu " + wantedBook.getTitle() + " s ID: " + wantedBook.getID() + "\n";
    }

    public void acceptRequest(Worker paAccepter)
    {
        paAccepter.reserveBook(wantedBook);
        ((Reader)this.requester.getOwner()).addBook(wantedBook);
    }

}
