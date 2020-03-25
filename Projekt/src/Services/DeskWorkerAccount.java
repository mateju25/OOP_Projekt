package Services;

import Library.Office;
import LogInScene.LogOutController;
import People.Human;
import Products.Book;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DeskWorkerAccount extends Account {
	
	public DeskWorkerAccount(Human paNewOwner) 
	{
		super(paNewOwner);
	}

	@Override
	public int reserveBook(Book paBook) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public int unreserveBook(Book paBook) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public String startScene() throws IOException {
		return "logOutSceneLibrarian.fxml";
	}

	/*@Override
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
	}*/

}
