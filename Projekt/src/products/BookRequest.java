package products;

import people.Reader;
import people.Worker;

public class BookRequest extends Request {
    //atributes
    private final int dataId;
    private final Book wantedBook;
    private final Account requester;

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
    public String getInfo() {
        return requester.getOwner().getName() + " požiadal o knihu " + wantedBook.getTitle() + " s ID: " + wantedBook.getID() + "\n";
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
