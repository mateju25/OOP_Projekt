package systems;

/**
 * Exception when password is wrong in user registration
 */
public class WrongPasswordException extends Exception {
    /**
     * creates a window with information for user
     */
    public WrongPasswordException() {
        AlertSystem window = new AlertSystem("Pozor", "Heslo musí mať aspoň jedno veľké písmeno, jedno císlo a 8 znakov.");
    }
}
