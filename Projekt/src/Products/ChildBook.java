package Products;

public class ChildBook extends Book{
	public ChildBook(String title, int numOfPages, double rating, int ID)
	{
		super(title, numOfPages, rating, ID);
	}
	public String getInfo()
	{
		return super.getInfo();
	}
}
