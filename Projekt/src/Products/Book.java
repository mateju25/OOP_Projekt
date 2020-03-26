package Products;
import Services.*;

public class Book {
	protected String title;
	protected int numOfPages;
	protected int ID;
	protected double rating;
	protected boolean reserved;

	public int getID() {
		return ID;
	}
	public String getTitle()
	{
		return this.title;
	}
	public int getNumOfPages() {
		return numOfPages;
	}

	public double getRating() {
		return rating;
	}

	public boolean isReserved() {
		return reserved;
	}

	protected Book(String paTitle, int paNumOfPages, double paRating, int paID)
	{
		this.numOfPages = paNumOfPages;
		this.title = paTitle;
		this.rating = paRating;
		this.ID = paID;
		this.reserved = false;
	}

	public void setReserve(boolean paRes)
	{
		this.reserved = paRes;
	};
}
