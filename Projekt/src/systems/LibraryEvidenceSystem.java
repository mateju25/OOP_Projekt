package systems;

import people.BookStocker;
import products.Account;
import products.Book;
import products.BookRequest;
import products.Request;

import java.io.*;
import java.util.LinkedList;

/**
 * Main class of library evidence system
 * @author Matej Delincak
 */
public class LibraryEvidenceSystem {
    private AccountSystem sysAcc = new AccountSystem();
    private BookSystem sysBook = new BookSystem();
    private RequestSystem sysReq = new RequestSystem();

    /**
     * @return system for accounts
     */
    public AccountSystem getSysAcc() {
        return sysAcc;
    }
    /**
     * @return system for books
     */
    public BookSystem getSysBook() {
        return sysBook;
    }

    /**
     * @return system for requests
     */
    public RequestSystem getSysReq() {
        return sysReq;
    }

    /**
     * creates library system a load all data
     */
    public LibraryEvidenceSystem() {
        sysAcc.addNewUserChildReader("Matej Delincák", "x", "x", true);
        sysAcc.addNewUserAdultReader("Peter Plevko", "y", "x", true);
        sysAcc.addNewUserWorker("Pirky", "z", "x", true);
        sysAcc.addNewUserStocker("Booker", "c", "x", true);
        BookStocker person = (BookStocker)sysAcc.findAccountName("Booker").getOwner();
        sysBook.addNewChildBook(person, "Rozprávky Hansa Christiana Andersena", 592, "ISBN 80-7145-980-1");
        sysBook.addNewAdultBook(person,"Teória literatúry", 254, "ISBN 80-85684-05-5", "Táto kniha je veľmi dobrá - odporúcam");
        sysBook.addNewAdultBook(person,"Psychológia a pedagogika dieťaťa", 292, "ISBN 80-7178-585-7");

        //sysReq.addNewBookReq(sysBook.findBook(0), sysAcc.findAccount(0));

        try {
            serializeOffice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deserializeOffice();

    }

    /**
     * serializes all systems in library - uses multithreading
     * @throws InterruptedException
     */
    public void serializeOffice() throws InterruptedException {
        Thread t1 = new Thread (sysAcc, "Account system");
        t1.start();
        Thread t2 = new Thread (sysBook, "Account system");
        t2.start();
        Thread t3 = new Thread (sysReq, "Account system");
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

    /**
     * deserializes all system from files a build connections between systems
     */
    public void deserializeOffice() {
        try {
            sysAcc.deserialize("accounts.out");
            sysBook.deserialize("books.out");


            //repair connections
            AccountSystem temporarySys = sysAcc;
            for (Account acc: (LinkedList<Account>) temporarySys.getListAdmin()) {
                if (acc.getOwner() instanceof Reader)
                {
                    LinkedList<Book> temp = ((people.Reader) acc.getOwner()).getMyBooks();
                    ((people.Reader) acc.getOwner()).setMyBooks(null);
                    for (Book b: temp) {
                        ((people.Reader) acc.getOwner()).addBook(sysBook.findBook(b.getID()));
                    }
                }
            }
            sysAcc = temporarySys;

            sysReq.deserialize("requests.out");
            //repair connections
            RequestSystem temporarySys2 = sysReq;
            sysReq = new RequestSystem();
            for (Request req: (LinkedList<Request>) temporarySys2.getListAdmin()) {
                if (req instanceof BookRequest)
                    sysReq.addNewBookReq(sysBook.findBook(((BookRequest)req).getWantedBook().getID()), sysAcc.findAccountID(req.getRequester().getOwner().getID()));
            }
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

