package Products;

import Services.AdultAccount;
import Services.ChildrenAccount;
import Services.StudentAccount;

public class AdultBook extends Book{
	public AdultBook(String paTitle, int paNumOfPages, double paRating)
	{
		super(paTitle, paNumOfPages, paRating);
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
