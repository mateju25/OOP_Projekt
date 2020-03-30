package Products;

import java.io.Serializable;

public abstract class Book implements Serializable {
	protected final String title;
	protected final int numOfPages;
	protected final int dataId;
	protected final String ISBN;
	protected boolean reserved;

	public int getID() {
		return dataId;
	}
	public String getTitle()
	{
		return this.title;
	}

	protected Book(int paID, String paTitle, int paNumOfPages, String paISBN)
	{
		this.numOfPages = paNumOfPages;
		this.title = paTitle;
		this.dataId = paID;
		this.ISBN = paISBN;
		this.reserved = false;
	}

	public void setReserve(boolean paRes)
	{
		this.reserved = paRes;
	}

	public abstract String getInfo();

}
