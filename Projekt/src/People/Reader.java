package People;

public class Reader implements Client {
    private int idNumber;
    private String name;

    public int getIdNumber()
    {
        return idNumber;
    };
    public void setIdNumber(int paNum)
    {
        idNumber = paNum;
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
