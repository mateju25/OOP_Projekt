package Library;

import Products.Account;
import Products.Book;
import Products.Request;
import Systems.AccountSystem;
import Systems.BookSystem;
import Systems.RequestSystem;

import java.io.*;
import java.util.LinkedList;

public class Office {
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
    public Office() {
        sysAcc.addNewUserChildReader("Matej Delinčák", "x", "x");
        sysAcc.addNewUserAdultReader("Peter Plevko", "y", "x");
        sysAcc.addNewUserWorker("Pirky", "z", "x");

        sysBook.addNewChildBook("Rozprávky Hansa Christiana Andersena", 592, "ISBN 80-7145-980-1");
        sysBook.addNewAdultBook("Teória literatúry", 254, "ISBN 80-85684-05-5", "Táto kniha je veľmi dobrá - odporúčam");
        sysBook.addNewAdultBook("Psychológia a pedagogika dieťaťa", 292, "ISBN 80-7178-585-7");

        //sysReq.addNewBookReq(sysBook.findBook(0), sysAcc.findAccount(0));

        serializeOffice();
        deserializeOffice();

    }

    //serializuje celu kniznicu
    public void serializeOffice() {
        try {
            sysAcc.serialize();
            sysBook.serialize();
            sysReq.serialize();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //deserializuje celu kniznicu a opravi prepojenia medzi objektami, ktore boli stratene pri serializacii
    public void deserializeOffice() {
        try {
            sysAcc.deserialize();
            sysBook.deserialize();
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

            sysReq.deserialize();
            //repair connections
            RequestSystem temporarySys2 = sysReq;
            sysReq = new RequestSystem();
            for (Request req: (LinkedList<Request>) temporarySys2.getListAdmin()) {
                sysReq.addNewBookReq(sysBook.findBook(req.getWantedBook().getID()), sysAcc.findAccount(req.getRequester().getOwner().getID()));
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

