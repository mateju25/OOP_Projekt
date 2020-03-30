package Products;

import java.io.Serializable;

public class AdultBook extends Book  implements Serializable {
	public AdultBook(int paId, String paTitle, int paNumOfPages, String paISBN)
	{
		super(paId, paTitle, paNumOfPages, paISBN);
	}

	@Override
	public String getInfo() {
		{
			String s;
			if(reserved)
				s = String.format("%3d: Kniha pre doslepých: %-40s %-18s - %s", this.dataId, this.title, this.ISBN, "rezervovan8");
			else
				s = String.format("%3d: Kniha pre doslepých: %-40s %-18s - %s", this.dataId, this.title, this.ISBN, "voľná");
			return s;
		}
	}

}
