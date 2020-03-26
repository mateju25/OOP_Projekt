package Services;

import People.*;
import java.io.Serializable;

public class Account implements Serializable {
    private String login;
    private String password;
    private Human owner;
    private int loginState;

    public Human getOwner()
    {
        return owner;
    }
    public int getLoginState()
    {
        return loginState;
    }

    public Account(Human paNewOwner)
    {
        owner = paNewOwner;
        login = '.' + paNewOwner.getName();
        KeyGenerator gen = new KeyGenerator();
        password = gen.getPassword();

        //
        password = "x";
        //

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

