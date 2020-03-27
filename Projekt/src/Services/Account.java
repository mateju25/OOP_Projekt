package Services;

import People.*;
import Products.Book;

import java.io.Serializable;
import java.util.LinkedList;

public class Account implements Serializable {
    private String login;
    private String password;
    private Human owner;
    private int loginState;
    private double bill;


    public double getBill() {
        return bill;
    }


    public Human getOwner()
    {
        return owner;
    }
    public int getLoginState()
    {
        return loginState;
    }

    public Account(Human paNewOwner, String paLogin, String paPass)
    {
        owner = paNewOwner;
        login = paLogin;
        password = paPass;

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
            s = String.format("%4d - Zakaznik: %s",((Reader)(this.owner)).getIdNumber(), ((Librarian)(this.owner)).getName());
        return s;
    }



}

