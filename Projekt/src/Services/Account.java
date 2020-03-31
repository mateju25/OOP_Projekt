package Services;

import People.*;

import java.io.Serializable;

public class Account implements Serializable {
    //atributes
    private final String login;
    private final String password;
    private final Human owner;
    private int loginState;
    private double bill;

    //getters
    public double getBill() {
        return this.bill;
    }
    public Human getOwner() {
        return this.owner;
    }
    public String getLogin()
    {
        return login;
    }
    public String getInfo() {
        String s;
        if(owner instanceof Librarian)
            s = String.format("%4d - Pracovnik: %s",((Librarian)(this.owner)).getID(), ((Librarian)(this.owner)).getName());
        else
            s = String.format("%4d - Zakaznik: %s",((Reader)(this.owner)).getID(), ((Librarian)(this.owner)).getName());
        return s;
    }

    //constructors
    public Account(ChildReader paNewOwner, String paLogin, String paPass) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        this.bill = -2.50;
        loginState = 0;
    }
    public Account(AdultReader paNewOwner, String paLogin, String paPass) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        this.bill = 0;
        this.loginState = 0;
    }
    public Account(Librarian paNewOwner, String paLogin, String paPass) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        this.bill = 0;
        this.loginState = 0;
    }
    //methods
    public int userLogin(String paLogin, String paPass) {
        if ((paLogin.equals(login)) && (password.equals(paPass))) {
            loginState = 1;
        }
        return loginState;
    }
    public void userLogOut()
    {
        loginState = 0;
    }
}

