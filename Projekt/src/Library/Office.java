package Library;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Products.AdultBook;
import Products.Book;
import Products.ChildBook;
import Services.*;
import java.io.*;
import java.util.LinkedList;

public class Office {
    private LinkedList<Account> listAcc = new LinkedList<Account>();
    private LinkedList<Book> listBook = new LinkedList<Book>();
    private LinkedList<Request> listReq = new LinkedList<Request>();
    private Account currUser;
    private int currReq = 0;
    //constructor
    public Office() {
        listAcc.add(new Account(new ChildReader(100, "Matej Delinčák"), "x", "x"));
        listAcc.add(new Account(new AdultReader(101, "Peter Plevko"), "y", "x"));
        listAcc.add(new Account(new Librarian(102, "Pirky"), "z", "x"));



        Book skuska = new ChildBook("Rozprávky Hansa Christiana Andersena", 592, 1, "ISBN 80-7145-980-1");
        Book skuska2 = new AdultBook("Teória literatúry", 254, 2, "ISBN 80-85684-05-5");
        listBook.add(skuska);
        listBook.add(skuska2);
        listBook.add(new AdultBook("Psychológia a pedagogika dieťaťa", 292, 3, "ISBN 80-7178-585-7"));

        //listReq.add(new BookRequest(skuska, listAcc.get(0)));
        //listReq.add(new BookRequest(skuska2, listAcc.get(0)));
        try {
            serialize();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            deserialize();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //getters and setters
    public Account getActiveUser()
    {
        return currUser;
    }
    public LinkedList<Book> getBooks()
    {
        return listBook;
    }
    public LinkedList<Account> getAccounts()
    {
        return listAcc;
    }
    public LinkedList<Request> getReqs()
    {
        return listReq;
    }

    //request metods
    public Request nextRequest() {
        if (currReq + 1 >= listReq.size())
            return null;
        else {
            currReq++;
            return listReq.get(currReq);
        }
    }
    public Request beginRequest() {
        currReq = 0;
        if (listReq.size() > 0)
            return listReq.get(currReq);
        else
            return null;
    }
    public Request getCurrRequest() {
        return listReq.get(currReq);
    }
    public void deleteRequest() {
        listReq.remove(currReq);
        if(currReq != 0) currReq--;
    }
    public boolean existsReq(Book paBook, Account paAcc) {
        for (Request req : listReq)
        {
            if  ((req.getWantedBook().equals(paBook)) && (req.getRequester().equals(paAcc))) return true;
        }
        return false;
    }
    public void createRequest(Request paNew)
    {
        listReq.add(paNew);
    }

    public Book findBook(int paID) {
        for(Book book : listBook)
        {
            if (book.getID() == paID) return book;
        }
        return null;
    }
    public int findUser(String paLogin, String paPass) {
        for (Account a : listAcc)
        {
            if (a.userLogin(paLogin, paPass) == 1)
            {
                currUser = a;
                return 1;
            }
        }
        return 0;
    }
    public void addUser(Account paAcc) {
        listAcc.add(paAcc);
    }
    public int countOfUsers()
    {
        return listAcc.size();
    }


    //serialization and deseralization
    public void serialize() throws ClassNotFoundException, IOException {
        ObjectOutputStream outA = new ObjectOutputStream(new FileOutputStream("accounts.out"));
        outA.writeObject(listAcc);
        outA.close();

        ObjectOutputStream outB = new ObjectOutputStream(new FileOutputStream("books.out"));
        outB.writeObject(listBook);
        outB.close();

        ObjectOutputStream outC = new ObjectOutputStream(new FileOutputStream("requests.out"));
        outC.writeObject(listReq);
        outC.close();
    }
    public void deserialize() throws ClassNotFoundException, IOException {
        ObjectInputStream inA = new ObjectInputStream(new FileInputStream("accounts.out"));
        listAcc = (LinkedList<Account>)inA.readObject();
        inA.close();

        ObjectInputStream inB = new ObjectInputStream(new FileInputStream("books.out"));
        listBook = (LinkedList<Book>)inB.readObject();
        inB.close();

        ObjectInputStream inC = new ObjectInputStream(new FileInputStream("requests.out"));
        listReq = (LinkedList<Request>)inC.readObject();
        inC.close();
    }

}

