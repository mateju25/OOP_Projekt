package products;

import java.io.Serializable;

/**
 * Special type of book available for kids (but adults can access it too)
 * @author Matej Delincak
 */
public class ChildBook extends Book implements Serializable {
	/**
	 * creates child book with review
	 * @param paID if of the book
	 * @param paTitle title of the book
	 * @param paNumOfPages number of pages
	 * @param paISBN isbn of the book
	 * @param paAuthor author of the book
	 * @param review review of the book
	 */
	public ChildBook(int paID, String paTitle, String paAuthor, int paNumOfPages, String paISBN, String review)
	{
		super(paID, paTitle, paAuthor, paNumOfPages, paISBN, review);
	}

	/**
	 * creates child book without review
	 * @param paID if of the book
	 * @param paTitle title of the book
	 * @param paNumOfPages number of pages
	 * @param paAuthor author of the book
	 * @param paISBN isbn of the book
	 */
	public ChildBook(int paID, String paTitle, String paAuthor, int paNumOfPages, String paISBN)
	{
		super(paID, paTitle, paAuthor, paNumOfPages, paISBN);
	}

	/**
	 * @return info about child book
	 */
	@Override
	public String getInfo() {
		{
			String s;
			if(reserved)
				s = String.format("%-40s, %-20s: %-12s: %-18s - Detská kniha", this.title, this.author, "rezervovaná", this.ISBN);
			else
				s = String.format("%-40s, %-20s: %-12s: %-18s - Detská kniha", this.title, this.author, "voľná", this.ISBN);
			return s;
		}
	}

}
