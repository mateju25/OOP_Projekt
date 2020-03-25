package LogInScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogOutController {

    @FXML
    private void logOutButtonClicked(ActionEvent event) throws IOException {

        System.out.println("Uzivatel odhlaseny");
        //lib.getActiveUser().userLogOut();
        Pane root = FXMLLoader.load(getClass().getResource("../LogInScene/logInScene.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}

