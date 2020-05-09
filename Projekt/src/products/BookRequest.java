package products;

import people.Reader;
import people.Worker;

/**
 * Book request when user want some book
 * @author Matej Delincak
 */
public class BookRequest extends Request {
    //atributes
    private final int dataId;
    private final Book wantedBook;
    private final Account requester;

    /**
     * creates a book request with its ID, specific book and requester of the book
     * @param paId id of the request
     * @param paBook {@link Book}
     * @param paRequester {@link Account}
     */
    public BookRequest(int paId, Book paBook, Account paRequester)
    {
        this.wantedBook = paBook;
        this.requester = paRequester;
        this.dataId = paId;
    }

    /**
     * @return requester of the book
     */
    public Account getRequester() {
        return this.requester;
    }

    /**
     *
     * @return book that requester wants
     */
    public Book getWantedBook() {
        return this.wantedBook;
    }

    /**
     * @return info about adult book
     */
    @Override
    public String getInfo() {
        return requester.getOwner().getName() + " požiadal o knihu " + wantedBook.getTitle() + " s ID: " + wantedBook.getID() + "\n";
    }
    /**
     * accept book request, accepter {@link Worker}
     * @param paAccepter {@link Worker}
     */
    @Override
    public void acceptRequest(Worker paAccepter) {
        paAccepter.reserveBook(wantedBook);
        ((Reader)this.requester.getOwner()).addBook(wantedBook);
        ((Reader)requester.getOwner()).addMessage(new Message("Vaša žiadost o knihu " + this.wantedBook.getTitle() + " bola prijatá."));
    }
    /**
     * declines book request, decliner {@link Worker}
     * @param paAccepter {@link Worker}
     */
    @Override
    public void declineRequest(Worker paAccepter) {
        ((Reader)requester.getOwner()).addMessage(new Message("Vaša žiadost o knihu " + this.wantedBook.getTitle() + " bola zamietnutá."));
    }
}
