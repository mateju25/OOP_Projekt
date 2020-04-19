package Products;

import People.*;

import java.io.Serializable;

public class Account implements Serializable {
    //atributes
    private final String login;
    private final String password;
    private final Human owner;


    private boolean verified;
    private int loginState;
    private double bill;

    //getters
    //vrati rozpocet uctu
    public double getBill() {
        return this.bill;
    }
    //vrati validtu uctu
    public boolean getVerified() {
        return this.verified;
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
            s = String.format("%4d - Zakaznik: %s",((Reader)(this.owner)).getID(), ((Reader)(this.owner)).getName());
        return s;
    }

    //setters
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    //constructors
    public Account(ChildReader paNewOwner, String paLogin, String paPass, boolean verified) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        this.bill = 0;
        loginState = 0;
        this.verified = verified;
    }
    public Account(AdultReader paNewOwner, String paLogin, String paPass, boolean verified) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        this.bill = -2.5;
        this.loginState = 0;
        this.verified = verified;
    }
    public Account(Librarian paNewOwner, String paLogin, String paPass, boolean verified) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        this.bill = 0;
        this.loginState = 0;
        this.verified = verified;
    }
    //methods
    //logne uzivatela
    public int userLogin(String paLogin, String paPass) {
        if ((paLogin.equals(login)) && (password.equals(paPass)) && (verified == true)) {
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

