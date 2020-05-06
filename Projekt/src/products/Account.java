package products;

import people.*;

import java.io.Serializable;

public class Account implements Serializable {
    //attributes
    private final String login;
    private final String password;
    private final Human owner;


    private boolean verified;
    private int loginState;

    //getters
    //vrati validitu uctu
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
            s = String.format("%4d - Pracovnik: %s", this.owner.getID(), this.owner.getName());
        else
            s = String.format("%4d - Zakaznik: %s", this.owner.getID(), this.owner.getName());
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
        loginState = 0;
        this.verified = verified;
    }
    public Account(AdultReader paNewOwner, String paLogin, String paPass, boolean verified) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        this.loginState = 0;
        this.verified = verified;
    }
    public Account(Librarian paNewOwner, String paLogin, String paPass, boolean verified) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        this.loginState = 0;
        this.verified = verified;
    }
    //methods
    //logne uzivatela
    public int userLogin(String paLogin, String paPass) {
        if ((paLogin.equals(login)) && (password.equals(paPass)) && (verified)) {
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

