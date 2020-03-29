package Services;

import People.*;

import java.io.Serializable;

public class Account implements Serializable {
    private final String login;
    private final String password;
    private final Human owner;
    private int loginState;
    private final double bill;


    public double getBill() {
        return bill;
    }


    public Human getOwner()
    {
        return owner;
    }
    public String getLogin()
    {
        return login;
    }

    public Account(Human paNewOwner, String paLogin, String paPass)
    {
        owner = paNewOwner;
        login = paLogin;
        //password = paPass;

        //
        password = "x";
        //
        if(paNewOwner instanceof ChildReader)
            bill = 0;
        else
            bill = -2.50;
        loginState = 0;
        System.out.println(login);
        System.out.println(password);
    }




    public int userLogin(String paLogin, String paPass)
    {
        if ((paLogin.equals(login)) && (password.equals(paPass))) {
            loginState = 1;
        }
        return loginState;
    }

    public void userLogOut()
    {
        loginState = 0;
    }

    public String getInfo()
    {
        String s;
        if(owner instanceof Librarian)
            s = String.format("%4d - Pracovnik: %s",((Librarian)(this.owner)).getWorkNumber(), ((Librarian)(this.owner)).getName());
        else
            s = String.format("%4d - Zakaznik: %s",((Reader)(this.owner)).getName(), ((Librarian)(this.owner)).getName());
        return s;
    }



}

