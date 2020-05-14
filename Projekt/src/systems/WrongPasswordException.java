package systems;

/**
 * Exception when password is wrong in user registration
 */
public class WrongPasswordException extends Exception {
    private String message;
    /**
     * creates a window with information for user
     */
    public WrongPasswordException() {
        this.message = "Heslo musí mať aspoň jedno veľké písmeno, jedno císlo a 8 znakov.";
    }

    /**
     * @return message of exception
     */
    public String getMess(){
        return this.message;
    }
}
