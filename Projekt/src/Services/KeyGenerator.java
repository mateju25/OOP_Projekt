package Services;

import java.util.Random;

public class KeyGenerator {
    private String password;

    public KeyGenerator()
    {
        Random rand = new Random();
        password = "";
        for (int i = 0; i < 8; i++)
        {
            int randNum = rand.nextInt(26) + 65;
            password = password + (char)randNum;
        }
    };

    public String getPassword()
    {
        return password;
    };
}
