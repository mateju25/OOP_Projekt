package Products;

import java.io.Serializable;

public class ChildBook extends Book implements Serializable {
	public ChildBook(String paTitle, int paNumOfPages, int paID, String paISBN)
	{
		super(paTitle, paNumOfPages, paID, paISBN);
	}
}
