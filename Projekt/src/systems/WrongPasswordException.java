package systems;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        AlertSystem window = new AlertSystem("Pozor", "Heslo musí mať aspoň jedno veľké písmeno, jedno císlo a 8 znakov.");
    }
}
