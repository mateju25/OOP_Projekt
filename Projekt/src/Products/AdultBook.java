package Products;

import java.io.Serializable;

public class AdultBook extends Book  implements Serializable {
	//constructor
	public AdultBook(int paId, String paTitle, int paNumOfPages, String paISBN, String review)
	{
		super(paId, paTitle, paNumOfPages, paISBN, review);
	}
	public AdultBook(int paId, String paTitle, int paNumOfPages, String paISBN)
	{
		super(paId, paTitle, paNumOfPages, paISBN);
	}

	//getters
	//vrati info o knihe vo forme Stringu
	@Override
	public String getInfo() {
		{
			String s;
			if(reserved)
				s = String.format("%3d: %-12s: %-40s %-18s - Kniha pre doslepých", this.dataId, "rezervovaná", this.title, this.ISBN);
			else
				s = String.format("%3d: %-12s: %-40s %-18s - Kniha pre doslepých", this.dataId, "voľná", this.title, this.ISBN);
			return s;
		}
	}
}
