package Library;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Services.AccountSystem;
import Products.AdultBook;
import Products.Book;
import Products.ChildBook;
import Services.*;
import java.io.*;

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
        Account acc = new Account(new ChildReader(100, "Matej Delinčák"), "x", "x");
        sysAcc.addUser(acc);
        sysAcc.addUser(new Account(new AdultReader(101, "Peter Plevko"), "y", "x"));
        sysAcc.addUser(new Account(new Librarian(102, "Pirky"), "z", "x"));



        Book skuska = new ChildBook("Rozprávky Hansa Christiana Andersena", 592, 1, "ISBN 80-7145-980-1");
        sysBook.addBook(skuska);
        sysBook.addBook(new AdultBook("Teória literatúry", 254, 2, "ISBN 80-85684-05-5"));
        sysBook.addBook(new AdultBook("Psychológia a pedagogika dieťaťa", 292, 3, "ISBN 80-7178-585-7"));

        sysReq.addReq(new BookRequest(skuska, acc));

        try {
            sysAcc.serialize();
            sysBook.serialize();
            sysReq.serialize();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            sysAcc.deserialize();
            sysBook.deserialize();
            sysReq.deserialize();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

