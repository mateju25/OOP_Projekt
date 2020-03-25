package Products;
import Services.*;

public abstract class Book {
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

	protected abstract boolean reserveBook(ChildrenAccount paAcc);
	protected abstract boolean reserveBook(StudentAccount paAcc);
	protected abstract boolean reserveBook(AdultAccount paAcc);
}
