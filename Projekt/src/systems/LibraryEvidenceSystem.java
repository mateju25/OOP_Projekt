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
        sysAcc.addNewUserChildReader("Matej Delinčák", "xmatej", "Matej2000", true);
        sysAcc.addNewUserAdultReader("Peter Plevko", "xpeter", "Peter2001", true);
        sysAcc.addNewUserWorker("Andrea Javoríková", "xaja", "Andrea1999", true);
        sysAcc.addNewUserStocker("Roman Páleník", "xroman", "Roman1885", true);
        BookStocker person = (BookStocker)sysAcc.findAccountName("Roman Páleník").getOwner();
        sysBook.addNewChildBook(person, "Rozprávky Hansa Christiana Andersena", "Hans-Andersen", 592, "ISBN 80-7145-980-1");
        sysBook.addNewAdultBook(person,"Teória literatúry", "Peter Párka", 254, "ISBN 80-85684-05-5", "Táto kniha je veľmi dobrá - odporúčam");
        sysBook.addNewAdultBook(person,"Psychológia a pedagogika dieťaťa", "Jozef Mrkvička", 292, "ISBN 80-7178-585-7");
        sysBook.addNewAdultBook(person,"Vojna a mier", "Leo Tolstoj", 1025, "ISBN 70-12384-05-5", "Veľmi zaujímavý príbeh");
        sysBook.addNewAdultBook(person,"Objektovo-orientované programovanie", "Valentino Vranic", 150, "ISBN 32-1278-626-7");
        sysBook.addNewChildBook(person, "Motýlia izba", "Lucinda Riley", 424, "ISBN 9788022211000");
        sysBook.addNewChildBook(person, "Hravé úlohy pre škôlkarov 2", "EX book", 32, "ISBN 5556667778882");
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
        Thread t2 = new Thread (sysBook, "Book system");
        t2.start();
        Thread t3 = new Thread (sysReq, "Request system");
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

