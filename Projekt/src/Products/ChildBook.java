package Products;

import java.io.Serializable;

public class ChildBook extends Book implements Serializable {
	public ChildBook(String paTitle, int paNumOfPages, int paID, String paISBN)
	{
		super(paTitle, paNumOfPages, paID, paISBN);
	}

	@Override
	public String getInfo() {
		{
			String s;
			if(reserved)
				s = String.format("%3d: Detská kniha       : %-40s %-18s - %s", this.ID, this.title, this.ISBN, "rezervovan8");
			else
				s = String.format("%3d: Detská kniha       : %-40s %-18s - %s", this.ID, this.title, this.ISBN, "voľná");
			return s;
		}
	}
}
