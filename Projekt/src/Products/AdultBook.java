package Products;

import Services.*;

public class AdultBook extends Book{
	public AdultBook(String paTitle, int paNumOfPages, double paRating, int ID)
	{
		super(paTitle, paNumOfPages, paRating, ID);
	}

	public boolean reserve(ChildrenAccount acc)
	{
		System.out.println("Kniha nemoze byt rezervovana dietatom");
		return false;
	}
	public boolean reserve(StudentAccount acc)
	{
		if(this.reserved = false) {
			this.reserved = true;
			System.out.println("Kniha rezervovana studentom");
			return true;
		} 
		return false;
	}
	public boolean reserve(AdultAccount acc)
	{
		if(this.reserved = false) {
			this.reserved = true;
			System.out.println("Kniha rezervovana dospelym");
			return true;
		} 
		return false;
	}
}
