package Services;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import Products.Book;

import java.io.*;
import java.util.LinkedList;

public class AccountSystem implements SimpleSystem, Serializable {

    private LinkedList<Account> listAcc = new LinkedList<Account>();
    private Account currUser;
    private static int maxID = 0;

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
    public Account findAccount(int paID) {
        for(Account acc : listAcc)
        {
            if (acc.getOwner().getID() == paID) return acc;
        }
        return null;
    }
    public void addNewUserChildReader(String name, String login, String password) {
        listAcc.add(new Account(new ChildReader(maxID, name), login, password));
        maxID++;
    }
    public void addNewUserAdultReader(String name, String login, String password) {
        listAcc.add(new Account(new AdultReader(maxID, name), login, password));
        maxID++;
    }
    public void addNewUserWorker(String name, String login, String password) {
        listAcc.add(new Account(new Librarian(maxID, name), login, password));
        maxID++;
    }
    public int countOfUsers()
    {
        return listAcc.size();
    }


    @Override
    public LinkedList getListAdmin() {
        return listAcc;
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
