package Products;

import java.io.Serializable;

public class ChildBook extends Book implements Serializable {
	public ChildBook(int paId, String paTitle, int paNumOfPages, String paISBN)
	{
		super(paId, paTitle, paNumOfPages, paISBN);
	}

	@Override
	public String getInfo() {
		{
			String s;
			if(reserved)
				s = String.format("%3d: Detská kniha       : %-40s %-18s - %s", this.dataId, this.title, this.ISBN, "rezervovaná");
			else
				s = String.format("%3d: Detská kniha       : %-40s %-18s - %s", this.dataId, this.title, this.ISBN, "voľná");
			return s;
		}
	}
}
