package Library;


public class Office {
    private LinkedList<Account> listAcc = new LinkedList<Account>();
    private LinkedList<Book> listBook = new LinkedList<Book>();
    private Account currUser;

    public Office()
    {
        for(int i =0; i < 3; i++)
        {
            Reader citatel = new Reader();
            citatel.setIdNumber(100 + i);
            switch (i)
            {
                case 0: {citatel.setName("Matej");listAcc.add(new StudentAccount(citatel));break;}
                case 1: {citatel.setName("Jozo");listAcc.add(new ChildrenAccount(citatel));break;}
                case 2: {citatel.setName("Jano");listAcc.add(new AdultAccount(citatel));break;}
            }
        }
        Librarian pracovnik = new Librarian();
        pracovnik.setName("Peter");
        pracovnik.setWorkNumber(100 + 10);
        listAcc.add(new DeskWorkerAccount(pracovnik));

        listBook.add(new ChildBook("Skuskova kniha", 10, 4.5));
        listBook.add(new ChildBook("Skuskova kniha2", 10, 4.5));
        listBook.add(new ChildBook("Skuskova kniha3", 10, 4.5));
        try {
            serialize();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            deserialize();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Account getActiveUser()
    {
        return currUser;
    }

    public LinkedList<Book> getBooks()
    {
        return listBook;
    }

    public LinkedList<Account> getAccounts()
    {
        return listAcc;
    }


    public int findUser(String paLogin, String paPass)
    {
        for (Account a : listAcc)
        {
            if (a.userLogin(paLogin, paPass) == 1)
            {
                currUser = a;
                return 1;
            }
        }
        return 0;
    }

    public void serialize() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("accounts.out"));
        out.writeObject(listAcc);
        out.close();
    }


    public void deserialize() throws ClassNotFoundException, IOException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("accounts.out"));
        listAcc = (LinkedList<Account>)in.readObject();
        in.close();
    }

}

