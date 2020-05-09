package systems;

import people.*;
import products.Account;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * System that holds and manages accounts in library
 * @author Matej Delincak
 */
public class AccountSystem extends SimpleSystem implements Serializable {
    //atributes
    private Account currUser;
    private static int maxID = 0;

    /**
     * @return account of current user that is logged in
     */
    public Account getCurrUser() {
        return currUser;
    }

    /**
     * @return random worker that exists
     */
    public Account getWorker() {
        ArrayList<Account> temp = new ArrayList<>();
        for (Account a: (LinkedList<Account>)list) {
            if (a.getOwner() instanceof Worker) temp.add(a);
        }
        Random rand = new Random();
        int x = rand.nextInt(temp.size());
        return temp.get(x);
    }

    /**
     * funcion that returns list of accounts - possible only for {@link Librarian}
     * @param person {@link Librarian}
     * @return list of accounts in system
     */
    @Override
    public LinkedList getList(Librarian person) {
        return (LinkedList<Account>)list;
    }

    /**
     * functions that logs user based on login and password
     * @param paLogin login of account
     * @param paPass password of account
     * @return true if login succes, false if login was not successful
     */
    public boolean logUser(String paLogin, String paPass) {
        for (Account a : (LinkedList<Account>)list)
        {
            if (a.userLogin(paLogin, paPass))
            {
                currUser = a;
                return true;
            }
        }
        return false;
    }

    /**
     * function that finds an account based on login
     * @param paLogin login of person
     * @return true if account exists, no if not
     */
    public boolean existUser(String paLogin) {
        for (Account a : (LinkedList<Account>)list)
        {
            if (a.getLogin().equals(paLogin)) return true;
        }
        return false;
    }

    /**
     * function that finds account based on unique ID
     * @param paID id of account
     * @return specific account with paID
     */
    public Account findAccountID(int paID) {
        for(Account acc : (LinkedList<Account>)list)
        {
            if (acc.getOwner().getID() == paID) return acc;
        }
        return null;
    }

    /**
     * function that finds account based on owner's name
     * @param paName name of account
     * @return specific account with specific name
     */
    public Account findAccountName(String paName) {
        for(Account acc : (LinkedList<Account>)list)
        {
            if (acc.getOwner().getName().equals(paName)) return acc;
        }
        return null;
    }

    /**
     * deletes specific account based on ID
     * @param paID id of account
     */
    public void deleteAccount(int paID) {
        int i = 0;
        for(Account acc : (LinkedList<Account>)list)
        {
            if (acc.getOwner().getID() == paID) list.remove(i);
            i++;
        }
    }

    /**
     * creates a new child reader together with account {@link ChildReader}
     * @param name name of the user
     * @param login login of the user
     * @param password password of the user
     * @param verified if the account is verified or not
     */
    public void addNewUserChildReader(String name, String login, String password, boolean verified) {
        list.add(new Account(new ChildReader(maxID, name), login, password, verified));
        maxID++;
    }

    /**
     * creates a new adult reader together with account {@link AdultReader}
     * @param name name of the user
     * @param login login of the user
     * @param password password of the user
     * @param verified if the account is verified or not
     */
    public void addNewUserAdultReader(String name, String login, String password, boolean verified) {
        list.add(new Account(new AdultReader(maxID, name), login, password, verified));
        maxID++;
    }

    /**
     * creates a new worker together with account {@link Worker}
     * @param name name of the user
     * @param login login of the user
     * @param password password of the user
     * @param verified if the account is verified or not
     */
    public void addNewUserWorker(String name, String login, String password, boolean verified) {
        list.add(new Account(new Librarian(maxID, name), login, password, verified));
        maxID++;
    }

    /**
     * creates a new book keeper together with account {@link BookStocker}
     * @param name name of the user
     * @param login login of the user
     * @param password password of the user
     * @param verified if the account is verified or not
     */
    public void addNewUserStocker(String name, String login, String password, boolean verified) {
        list.add(new Account(new BookStocker(maxID, name), login, password, verified));
        maxID++;
    }

    /**
     * serializes account system into file "accounts.out"
     */
    public void run() {
        try {
            serialize("accounts.out");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
