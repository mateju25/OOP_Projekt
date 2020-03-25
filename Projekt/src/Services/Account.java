package Services;

import People.*;
import Products.*;
import java.io.Serializable;

public abstract class Account implements Serializable {
    protected String login;
    protected String password;
    protected Human owner;
    protected int loginState;
    protected double bill;

    protected Account(Human paNewOwner)
    {
        owner = paNewOwner;
        login = '.' + paNewOwner.getName();
        KeyGenerator gen = new KeyGenerator();
        password = gen.getPassword();
        loginState = 0;
        bill = 0;
        System.out.println(login);
        System.out.println(password);
    }


    public Human getOwner()
    {
        return owner;
    }
    public int getLoginState()
    {
        return loginState;
    }

    public int userLogin(String paLogin, String paPass)
    {
        if ((paLogin.equals(login)) && (password.equals(paPass))) {
            loginState = 1;
            System.out.println(bill);
        }
        else loginState = 0;
        return loginState;
    }

    public void userLogOut()
    {
        loginState = 0;
    }

    public abstract int reserveBook(Book paBook);
    public abstract int unreserveBook(Book paBook);
    public abstract FlowPane startScene(Office lib, FlowPane pane);

}

