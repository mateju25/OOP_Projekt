package Systems;

import People.BookStocker;
import Products.Account;
import Products.Book;
import Products.BookRequest;
import Products.Request;

import java.io.*;
import java.util.LinkedList;

public class LibraryEvidenceSystem {
    private AccountSystem sysAcc = new AccountSystem();
    private BookSystem sysBook = new BookSystem();
    private RequestSystem sysReq = new RequestSystem();

    public AccountSystem getSysAcc() {
        return sysAcc;
    }
    public BookSystem getSysBook() {
        return sysBook;
    }
    public RequestSystem getSysReq() {
        return sysReq;
    }

    //constructor
    public LibraryEvidenceSystem() {
        sysAcc.addNewUserChildReader("Matej Delinčák", "x", "x", true);
        sysAcc.addNewUserAdultReader("Peter Plevko", "y", "x", true);
        sysAcc.addNewUserWorker("Pirky", "z", "x", true);
        sysAcc.addNewUserStocker("Booker", "c", "x", true);
        BookStocker person = (BookStocker)sysAcc.findAccountName("Booker").getOwner();
        sysBook.addNewChildBook(person, "Rozprávky Hansa Christiana Andersena", 592, "ISBN 80-7145-980-1");
        sysBook.addNewAdultBook(person,"Teória literatúry", 254, "ISBN 80-85684-05-5", "Táto kniha je veľmi dobrá - odporúčam");
        sysBook.addNewAdultBook(person,"Psychológia a pedagogika dieťaťa", 292, "ISBN 80-7178-585-7");

        //sysReq.addNewBookReq(sysBook.findBook(0), sysAcc.findAccount(0));

        try {
            serializeOffice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deserializeOffice();

    }

    //serializuje celu kniznicu
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

    //deserializuje celu kniznicu a opravi prepojenia medzi objektami, ktore boli stratene pri serializacii
    public void deserializeOffice() {
        try {
            sysAcc.deserialize("accounts.out");
            sysBook.deserialize("books.out");


            //repair connections
            AccountSystem temporarySys = sysAcc;
            for (Account acc: (LinkedList<Account>) temporarySys.getListAdmin()) {
                if (acc.getOwner() instanceof Reader)
                {
                    LinkedList<Book> temp = ((People.Reader) acc.getOwner()).getMyBooks();
                    ((People.Reader) acc.getOwner()).setMyBooks(null);
                    for (Book b: temp) {
                        ((People.Reader) acc.getOwner()).addBook(sysBook.findBook(b.getID()));
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
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
