package Products;

import Services.*;

import java.io.Serializable;

public class AdultBook extends Book  implements Serializable {
	public AdultBook(String paTitle, int paNumOfPages, int paID, String paISBN)
	{
		super(paTitle, paNumOfPages, paID, paISBN);
	}

}
