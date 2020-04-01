package Systems;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        AlertSystem window = new AlertSystem("Pozor", "Heslo musí mať aspoň jedno veľké písmeno, jedno číslo a 8 znakov.");
    }
}
