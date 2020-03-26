package Library;

import Products.Book;
import Services.Account;

public class BookRequest implements Request {
    private Book wantedBook;
    private Account requester;

    public Account getRequester() {
        return requester;
    }

    public Book getWantedBook() {
        return wantedBook;
    }
    BookRequest(Book paBook, Account paRequester)
    {
        this.wantedBook = paBook;
        this.requester = paRequester;
    }

    @Override
    public String showMessage() {
        return requester.getOwner().getName() + " poziadal o knihu " + wantedBook.getTitle() + " s ID: " + wantedBook.getID() + "\n";
    }

    public void acceptRequest()
    {
        requester.reserveBook(wantedBook);
    }

}
