package Products;

import java.io.Serializable;

public abstract class Book implements Serializable {
	protected final String title;
	protected final int numOfPages;
	protected final int ID;
	protected final String ISBN;
	protected boolean reserved;

	public int getID() {
		return ID;
	}
	public String getTitle()
	{
		return this.title;
	}

	protected Book(String paTitle, int paNumOfPages, int paID, String paISBN)
	{
		this.numOfPages = paNumOfPages;
		this.title = paTitle;
		this.ID = paID;
		this.ISBN = paISBN;
		this.reserved = false;
	}

	public void setReserve(boolean paRes)
	{
		this.reserved = paRes;
	}

	public abstract String getInfo();

}
