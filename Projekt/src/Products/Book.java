package Products;
import Services.*;

public class Book {
	protected String title;
	protected int numOfPages;
	protected double rating;
	protected boolean reserved;

	protected Book(String paTitle, int paNumOfPages, double paRating)
	{
		this.numOfPages = paNumOfPages;
		this.title = paTitle;
		this.rating = paRating;
		this.reserved = false;
	}


	public boolean reserve(ChildrenAccount acc)
	{
		return false;
	};
	public boolean reserve(StudentAccount acc)
	{
		return false;
	};
	public boolean reserve(AdultAccount acc)
	{
		return false;
	};

	public boolean unreserve()
	{
		this.reserved = false;
		return true;
	};
}
