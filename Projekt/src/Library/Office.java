package Library;
import People.Librarian;
import People.Reader;
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

    public Office()
    {
        Reader citatel = new Reader();
        for(int i =0; i < 1; i++)
        {

            citatel.setIdNumber(100 + i);
            switch (i)
            {
                case 0: {citatel.setName("Matej");listAcc.add(new AdultAccount(citatel));break;}
                case 1: {citatel.setName("Jozo");listAcc.add(new AdultAccount(citatel));break;}
                case 2: {citatel.setName("Jano");listAcc.add(new AdultAccount(citatel));break;}
            }
        }
        Librarian pracovnik = new Librarian();
        pracovnik.setName("Peter");
        pracovnik.setWorkNumber(100 + 10);
        listAcc.add(new DeskWorkerAccount(pracovnik));

        Book skuska = new ChildBook("Skuskova kniha", 10, 4.5, 1);
        Book skuska2 = new ChildBook("Skuskova kniha2", 10, 4.5, 2);
        listBook.add(skuska);
        listBook.add(skuska2);
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 3));
        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5, 4));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5, 5));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 6));
        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5, 7));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5, 8));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 9));
        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5, 10));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5, 11));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 12));
        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5, 13));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5, 14));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 15));
        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5, 1));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5, 2));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 3));
        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5, 4));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5, 5));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 6));
        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5, 7));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5, 8));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 9));
        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5, 10));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5, 11));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 12));
        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5, 13));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5, 14));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5, 15));

        listReq.add(new BookRequest(skuska, listAcc.get(0)));
        listReq.add(new BookRequest(skuska2, listAcc.get(0)));
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
    public void deleteRequest()
    {
        listReq.remove(currReq);
        if(currReq != 0) currReq--;
    }



    public int findUser(String paLogin, String paPass)
    {
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

    public void serialize() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("accounts.out"));
        out.writeObject(listAcc);
        out.close();
    }


    public void deserialize() throws ClassNotFoundException, IOException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("accounts.out"));
        listAcc = (LinkedList<Account>)in.readObject();
        in.close();
    }

}

