package Library;

import People.Reader;
import People.Worker;
import Products.Book;
import Products.Message;
import Services.Account;

public class BookRequest implements Request {
    //atributes
    private final int dataId;
    private Book wantedBook;
    private Account requester;

    //constructor
    public BookRequest(int paId, Book paBook, Account paRequester)
    {
        this.wantedBook = paBook;
        this.requester = paRequester;
        this.dataId = paId;
    }

    //getters
    public Account getRequester() {
        return this.requester;
    }
    public Book getWantedBook() {
        return this.wantedBook;
    }

    //methods
    @Override
    public String showMessage() {
        return requester.getOwner().getName() + " poziadal o knihu " + wantedBook.getTitle() + " s ID: " + wantedBook.getID() + "\n";
    }
    @Override
    public void acceptRequest(Worker paAccepter) {
        paAccepter.reserveBook(wantedBook);
        ((Reader)this.requester.getOwner()).addBook(wantedBook);
        ((Reader)requester.getOwner()).addMessage(new Message("Vaša žiadost o knihu " + this.wantedBook.getTitle() + " bola prijatá."));
    }
    @Override
    public void declineRequest() {
        ((Reader)requester.getOwner()).addMessage(new Message("Vaša žiadost o knihu " + this.wantedBook.getTitle() + " bola zamietnutá."));
    }
}
