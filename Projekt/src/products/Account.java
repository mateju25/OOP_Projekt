package products;

import people.*;

import java.io.Serializable;

/**
 * Account that has owner and login with password
 * @author Matej Delincak
 */
public class Account implements Serializable {
    //attributes
    private final String login;
    private final String password;
    private final Human owner;
    private boolean verified;
    private boolean loginState;

    /**
     * @return true if account is verified by any of worker
     */
    public boolean getVerified() {
        return this.verified;
    }

    /**
     * @return owner of this account
     */
    public Human getOwner() {
        return this.owner;
    }

    /**
     * @return login of the account
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * verifies book if verified is true
     * @param verified state of verification
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * creates account with parameters
     * @param paNewOwner owner of the {@link Account}
     * @param paLogin login of the user
     * @param paPass password of the user
     * @param verified state of verification
     */
    public Account(Human paNewOwner, String paLogin, String paPass, boolean verified) {
        this.owner = paNewOwner;
        this.login = paLogin;
        this.password = paPass;
        loginState = false;
        this.verified = verified;
    }

    /**
     * tries to log in based on login and password
     * @param paLogin login of the user
     * @param paPass password of the user
     * @return false if not successful, true if successful
     */
    public boolean userLogin(String paLogin, String paPass) {
        if ((paLogin.equals(login)) && (password.equals(paPass)) && (verified)) {
            loginState = true;
        }
        return loginState;
    }

    /**
     * user log out
     */
    public void userLogOut()
    {
        loginState = false;
    }
}

