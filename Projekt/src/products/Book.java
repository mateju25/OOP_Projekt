package products;

import java.io.Serializable;

/**
 * Basic book with basic functions
 */
public abstract class Book implements Serializable, Product {
	//atributes
	/**
	 * review of the book
	 */
	protected Review textReview;
	/**
	 * title of the book
	 */
	protected final String title;
	/**
	 * number of pages in the book
	 */
	protected final int numOfPages;
	/**
	 * specific data id
	 */
	protected final int dataId;
	/**
	 * isbn of the book
	 */
	protected final String ISBN;
	/**
	 * true if book is already reserved
	 */
	protected boolean reserved;

	/**
	 * Review enclosed class
	 */
	protected static class Review implements Serializable {
		private final String text;

		/**
		 * creates and set text for review
		 * @param s text of the review
		 */
		public Review (String s) {this.text = s;}

		/**
		 * @return text of the review
		 */
		public String getText() {
			return text;
		}
	}

	/**
	 * creates book with parameters and review
	 * @param paID if of the book
	 * @param paTitle title of the book
	 * @param paNumOfPages number of pages
	 * @param paISBN isbn of the book
	 * @param review review of the book
	 */
	protected Book(int paID, String paTitle, int paNumOfPages, String paISBN, String review) {
		this.numOfPages = paNumOfPages;
		this.title = paTitle;
		this.dataId = paID;
		this.ISBN = paISBN;
		this.reserved = false;
		this.textReview = new Review(review);
	}

	/**
	 * creates book with parameters but without review
	 * @param paID if of the book
	 * @param paTitle title of the book
	 * @param paNumOfPages number of pages
	 * @param paISBN isbn of the book
	 */
	protected Book(int paID, String paTitle, int paNumOfPages, String paISBN) {
		this.numOfPages = paNumOfPages;
		this.title = paTitle;
		this.dataId = paID;
		this.ISBN = paISBN;
		this.reserved = false;
	}

	/**
	 * @return ID of the book
	 */
	public int getID() {
		return dataId;
	}

	/**
	 * @return title of the book
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * @return info about book
	 */
	public abstract String getInfo();
	//vrati recenziu
	public String getReview() {
		if (textReview != null)
			return textReview.getText();
		else
			return null;
	}

	/**
	 * set book to reserved if paRes is true, or unreserved if false
	 * @param paRes state of reservation
	 */
	public void setReserve(boolean paRes)
	{
		this.reserved = paRes;
	}

	/**
	 * @return the state of reservation
	 */
	public boolean getReserve()
	{
		return this.reserved;
	}
}
