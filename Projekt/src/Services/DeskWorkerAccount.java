package Services;

import Library.Office;
import People.Human;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;

public class DeskWorkerAccount extends Account {
	
	public DeskWorkerAccount(Human paNewOwner) 
	{
		super(paNewOwner);
	}
	
	@Override
	public int reserveBook(Book paBook) {
		// TODO Auto-generated method stub
		System.out.println("Kniha zarezervovana");
		paBook.setReserved(true);
		return 1;
	}

	@Override
	public int unreserveBook(Book paBook) {
		// TODO Auto-generated method stub
		paBook.setReserved(false);
		System.out.println("Kniha vratena");
		return 1;
	}

	@Override
	public FlowPane startScene(Office lib, FlowPane pane){
		// TODO Auto-generated method stub
		Button showAccounts = new Button("Show Accounts");
		Button showBooks = new Button("Show Books");
		TextArea text = new TextArea();
		//ScrollPane scroll = new ScrollPane();
		
		showAccounts.setOnAction(e -> { 
			System.out.println("Uzivatel vyhladal vsetky ucty");
			text.clear();
			for(Account a : lib.getAccounts()) {
				
				text.appendText(a.owner.getName() + "\n");
				
				text.setEditable(false);
			}
			
		}); 
		
		showBooks.setOnAction(e -> { 
			System.out.println("Uzivatel vyhladal vsetky knihy");
			text.clear();
			for(Book a : lib.getBooks()) {
				
				text.appendText(a.title + "\n");
				
				text.setEditable(false);
			}
			
		}); 
		
		pane.getChildren().add(text);
		pane.getChildren().add(showAccounts);
		pane.getChildren().add(showBooks);


		return pane;
	}

}
