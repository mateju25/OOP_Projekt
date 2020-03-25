package Products;

import Services.AdultAccount;
import Services.ChildrenAccount;
import Services.StudentAccount;

public class ChildBook extends Book{
	public ChildBook(String title, int numOfPages, double rating, int ID)
	{
		super(title, numOfPages, rating, ID);
	}
	
	public boolean reserve(ChildrenAccount acc)
	{
		if(this.reserved = false) {
			this.reserved = true;
			System.out.println("Kniha rezervovana dietatom");
			return true;
		} 
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
		System.out.println("Kniha nemoze byt rezervovana dospelym");
		return false;
	}
}
