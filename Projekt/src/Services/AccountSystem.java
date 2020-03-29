package Services;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;

import java.io.*;
import java.util.LinkedList;

public class AccountSystem implements SimpleSystem {

    private LinkedList<Account> listAcc = new LinkedList<Account>();
    private Account currUser;

    public Account getCurrUser() {
        return currUser;
    }

    public int logUser(String paLogin, String paPass) {
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
    public boolean findUser(String paLogin) {
        for (Account a : listAcc)
        {
            if (a.getLogin().equals(paLogin)) return true;
        }
        return false;
    }
    public void addUser(Account paAcc) {
        listAcc.add(paAcc);
    }
    public int countOfUsers()
    {
        return listAcc.size();
    }


    @Override
    public LinkedList getList(AdultReader person) {
        return null;
    }

    @Override
    public LinkedList getList(ChildReader person) {
        return null;
    }

    @Override
    public LinkedList getList(Librarian person) {
        return listAcc;
    }

    public void serialize() throws IOException {
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
