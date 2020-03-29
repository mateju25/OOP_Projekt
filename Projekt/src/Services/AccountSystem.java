package Services;

import Library.Request;
import LogInScene.SimpleController;
import Products.Book;

import java.io.*;
import java.util.LinkedList;

public class AccountSystem implements SimpleSystem {

    private LinkedList<Account> listAcc = new LinkedList<Account>();
    private Account currUser;

    public LinkedList<Account> getListAcc() {
        return listAcc;
    }
    public Account getCurrUser() {
        return currUser;
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


    public void serialize() throws ClassNotFoundException, IOException {
        ObjectOutputStream outA = new ObjectOutputStream(new FileOutputStream("accounts.out"));
        outA.writeObject(listAcc);
        outA.close();
    }
    public void deserialize() throws ClassNotFoundException, IOException {
        ObjectInputStream inA = new ObjectInputStream(new FileInputStream("accounts.out"));
        listAcc = (LinkedList<Account>)inA.readObject();
        inA.close();
    }
}
