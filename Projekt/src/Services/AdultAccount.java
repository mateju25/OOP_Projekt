package Services;

import Library.Office;
import People.Human;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdultAccount extends Account{
	public AdultAccount(Human paNewOwner) 
	{
		super(paNewOwner);
		bill = -2.50;
	}

	@Override
	public int reserveBook(Book paBook) {
		// TODO Auto-generated method stub
		System.out.println("Kniha nemoze byt zarezervovana tymto uzivatelom");
		return 0;
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

		Button showBooks = new Button("Show Books");
		TextArea text = new TextArea();
		//ScrollPane scroll = new ScrollPane();

		
		showBooks.setOnAction(e -> { 
			System.out.println("Uzivatel vyhladal vsetky knihy");
			text.clear();
			for(Book a : lib.getBooks()) {
				
				text.appendText(a.title + "\n");
				
				text.setEditable(false);
			}
			
		}); 
		
		pane.getChildren().add(text);

		pane.getChildren().add(showBooks);


		return pane;
	}
}

