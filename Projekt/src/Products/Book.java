package Products;
import Services.*;

import java.io.Serializable;

public class Book implements Serializable {
	protected String title;
	protected int numOfPages;
	protected int ID;
	protected String ISBN;
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
	};

	public String getInfo()
	{
		String s;
		if(reserved)
			s = String.format("%3d: %-40s :%-18s - %s", this.ID, this.title, this.ISBN, "rezervovana");
		else
			s = String.format("%3d: %-40s :%-18s - %s", this.ID, this.title, this.ISBN, "volna");
		return s;
	}
}
