package Services;

import Library.Office;
import People.Human;
import Products.Book;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

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
		paBook.unreserve();
		System.out.println("Kniha vratena");
		return 1;
	}

	@Override
	public String startScene() throws IOException {
		return "logOutSceneClient.fxml";
	}
}

