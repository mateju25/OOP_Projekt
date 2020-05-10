package products;

import java.io.Serializable;

/**
 * Special type of book only available for adults
 * @author Matej Delincak
 */
public class AdultBook extends Book  implements Serializable {
	/**
	 * creates adult book with review
	 * @param paId if of the book
	 * @param paTitle title of the book
	 * @param paNumOfPages number of pages
	 * @param paISBN isbn of the book
	 * @param review review of the book
	 */
	public AdultBook(int paId, String paTitle, int paNumOfPages, String paISBN, String review)
	{
		super(paId, paTitle, paNumOfPages, paISBN, review);
	}

	/**
	 * creates adult book without review
	 * @param paId if of the book
	 * @param paTitle title of the book
	 * @param paNumOfPages number of pages
	 * @param paISBN isbn of the book
	 */
	public AdultBook(int paId, String paTitle, int paNumOfPages, String paISBN)
	{
		super(paId, paTitle, paNumOfPages, paISBN);
	}

	/**
	 * @return info about adult book
	 */
	@Override
	public String getInfo() {
		{
			String s;
			if(reserved)
				s = String.format("%3d: %-12s: %-40s %-18s - Kniha pre dospelých", this.dataId, "rezervovaná", this.title, this.ISBN);
			else
				s = String.format("%3d: %-12s: %-40s %-18s - Kniha pre dospelých", this.dataId, "voľná", this.title, this.ISBN);
			return s;
		}
	}
}
