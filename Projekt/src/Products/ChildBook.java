package Products;

import Services.AdultAccount;
import Services.ChildrenAccount;
import Services.StudentAccount;

public class ChildBook extends Book{
	public ChildBook(String title, int numOfPages, double rating) 
	{
		super(title, numOfPages, rating);
	}
	
	public boolean reserveBook(ChildrenAccount acc)
	{
		if(this.reserved = false) {
			this.reserved = true;
			System.out.println("Kniha rezervovana dietatom");
			return true;
		} 
		return false;
	}
	public boolean reserveBook(StudentAccount acc)
	{
		if(this.reserved = false) {
			this.reserved = true;
			System.out.println("Kniha rezervovana studentom");
			return true;
		} 
		return false;
	}
	public boolean reserveBook(AdultAccount acc)
	{
		System.out.println("Kniha nemoze byt rezervovana dospelym");
		return false;
	}
}
