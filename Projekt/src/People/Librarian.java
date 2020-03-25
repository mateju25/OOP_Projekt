package People;

public class Librarian implements Worker {
    private int workNumber;
    private String name;

    public int getWorkNumber()
    {
        return workNumber;
    };
    public void setWorkNumber(int paNum)
    {
        workNumber = paNum;
    };
    public String getName()
    {
        return name;
    };
    public void setName(String paName)
    {
        name = paName;
    };
}
