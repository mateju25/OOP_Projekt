package Products;

import java.io.Serializable;

public abstract class Book implements Serializable {
	//atributes
	protected Review textReview;
	protected final String title;
	protected final int numOfPages;
	protected final int dataId;
	protected final String ISBN;
	protected boolean reserved;

	//enclosed class
	protected class Review implements Serializable {
		private String text;

		public Review (String s) {this.text = s;}

		public String getText() {
			return text;
		}
	}

	//constructor
	protected Book(int paID, String paTitle, int paNumOfPages, String paISBN, String review) {
		this.numOfPages = paNumOfPages;
		this.title = paTitle;
		this.dataId = paID;
		this.ISBN = paISBN;
		this.reserved = false;
		this.textReview = new Review(review);
	}
	protected Book(int paID, String paTitle, int paNumOfPages, String paISBN) {
		this.numOfPages = paNumOfPages;
		this.title = paTitle;
		this.dataId = paID;
		this.ISBN = paISBN;
		this.reserved = false;
	}

	//getters
	public int getID() {
		return dataId;
	}
	public String getTitle()
	{
		return this.title;
	}
	//vrati info o knihe vo forme Stringu
	public abstract String getInfo();
	//vrati recenziu
	public String getReview() {
		if (textReview != null)
			return textReview.getText();
		else
			return null;
	}

	//setters
	//nastavi rezervaciu na rezervovane
	public void setReserve(boolean paRes)
	{
		this.reserved = paRes;
	}
}
