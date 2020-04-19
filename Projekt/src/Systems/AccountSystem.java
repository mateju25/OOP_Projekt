package Systems;

import People.AdultReader;
import People.ChildReader;
import People.Librarian;
import People.Worker;
import Products.Account;

import java.io.*;
import java.util.LinkedList;

public class AccountSystem extends SimpleSystem implements Serializable {
    //atributes
    private Account currUser;
    private static int maxID = 0;

    //getters
    //vrati aktualneho pouzivatela
    public Account getCurrUser() {
        return currUser;
    }
    //vrati prveho zamestnanca, ktory existuje v zozname
    public Account getFirstWorker() {
        for (Account a: (LinkedList<Account>)list) {
            if (((Account)a).getOwner() instanceof Worker) return a;
        }
        return null;
    }
    //vrati zoznam uctov na zaklade ziadatela
    @Override
    public LinkedList getList(Librarian person) {
        return (LinkedList<Account>)list;
    }

    //methods
    //prihlasi uzivatela
    public int logUser(String paLogin, String paPass) {
        for (Account a : (LinkedList<Account>)list)
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
        for (Account a : (LinkedList<Account>)list)
        {
            if (a.getLogin().equals(paLogin)) return true;
        }
        return false;
    }
    //najde ucet na zaklade ID
    public Account findAccount(int paID) {
        for(Account acc : (LinkedList<Account>)list)
        {
            if (acc.getOwner().getID() == paID) return acc;
        }
        return null;
    }

    //vytvori ucet s konkretnym vlastnikom
    public void addNewUserChildReader(String name, String login, String password) {
        list.add(new Account(new ChildReader(maxID, name), login, password));
        maxID++;
    }
    public void addNewUserAdultReader(String name, String login, String password) {
        list.add(new Account(new AdultReader(maxID, name), login, password));
        maxID++;
    }
    public void addNewUserWorker(String name, String login, String password) {
        list.add(new Account(new Librarian(maxID, name), login, password));
        maxID++;
    }

    //serialization
    public void run() {
        ///System.out.println("Account start");
        try {
            serialize("accounts.out");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Account end");
    }
}
