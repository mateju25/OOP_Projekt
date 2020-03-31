package Systems;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import People.Worker;
import Products.Account;

import java.io.*;
import java.util.LinkedList;

public class AccountSystem implements SimpleSystem, Serializable {
    //atributes
    private LinkedList<Account> listAcc = new LinkedList<Account>();
    private Account currUser;
    private static int maxID = 0;

    //getters
    //vrati aktualneho pouzivatela
    public Account getCurrUser() {
        return currUser;
    }
    //vrati prveho zamestnanca, ktory existuje v zozname
    public Account getFirstWorker() {
        for (Account a: listAcc) {
            if (a.getOwner() instanceof Worker) return a;
        }
        return null;
    }
    //vrati zoznam uctov na zaklade ziadatela
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

    //methods
    //prihlasi uzivatela
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
    //najde uzivatela na zaklade loginu
    public boolean findUser(String paLogin) {
        for (Account a : listAcc)
        {
            if (a.getLogin().equals(paLogin)) return true;
        }
        return false;
    }
    //najde ucet na zaklade ID
    public Account findAccount(int paID) {
        for(Account acc : listAcc)
        {
            if (acc.getOwner().getID() == paID) return acc;
        }
        return null;
    }

    //vytvori ucet s konkretnym vlastnikom
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

    //serializaction
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
