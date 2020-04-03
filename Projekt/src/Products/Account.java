package Products;

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
    //vrati rozpocet uctu
    public double getBill() {
        return this.bill;
    }
    //vrati vlastnika
    public Human getOwner() {
        return this.owner;
    }
    //vrati login uctu
    public String getLogin()
    {
        return login;
    }
    //vrati info o ucte
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
        this.bill = 0;
        loginState = 0;
    }
    public Account(AdultReader paNewOwner, String paLogin, String paPass) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        this.bill = -2.5;
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
    //logne uzivatela
    public int userLogin(String paLogin, String paPass) {
        if ((paLogin.equals(login)) && (password.equals(paPass))) {
            loginState = 1;
        }
        return loginState;
    }
    //odhlasi uzivatela
    public void userLogOut()
    {
        loginState = 0;
    }
}

