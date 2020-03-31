package Products;

import java.io.Serializable;

public abstract class Book implements Serializable {
	//atributes
	protected final String title;
	protected final int numOfPages;
	protected final int dataId;
	protected final String ISBN;
	protected boolean reserved;

	//constructor
	protected Book(int paID, String paTitle, int paNumOfPages, String paISBN)
	{
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

	//setters
	//nastavi rezervaciu na rezervovane
	public void setReserve(boolean paRes)
	{
		this.reserved = paRes;
	}
}
