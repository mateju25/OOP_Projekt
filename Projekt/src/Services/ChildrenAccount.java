package Services;

import Library.Office;
import People.Human;


public class ChildrenAccount extends Account{
    public ChildrenAccount(Human paNewOwner)
    {
        super(paNewOwner);
        bill = 0;
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
    public FlowPane startScene(Office lib, FlowPane pane) {
        // TODO Auto-generated method stub
        TextField textForBooks = new TextField();

        pane.getChildren().add(textForBooks);

        return pane;
    }
}

