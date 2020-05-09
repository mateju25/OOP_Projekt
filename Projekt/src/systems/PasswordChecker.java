package systems;

/**
 * This class checks correctness of password
 * @author Matej Delincak
 */
public class PasswordChecker {
    /**
     * function checks potential password if it fulfills the conditions (length of 8 chars, one big letter and one number)
     * @param potentialPass potential password
     * @throws WrongPasswordException
     */
    public void checkPass(String potentialPass) throws WrongPasswordException
    {
        if (potentialPass.length() < 8) throw new WrongPasswordException();
        boolean isBig = false, isNumber = false;
        for (int i = 0; i < potentialPass.length(); i++)
        {
            if ((potentialPass.charAt(i) >= 65) && (potentialPass.charAt(i) <= 90)) isBig = true;
            if ((potentialPass.charAt(i) >= 48) && (potentialPass.charAt(i) <= 57)) isNumber = true;
        }
        if ((isBig) && (isNumber))
            return;
        else
            throw new WrongPasswordException();
    }
}
