package LogInScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller {
    @FXML
    private Pane pane1;
    @FXML
    private void logInButtonClicked(ActionEvent event) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("secondscene.fxml"));
        pane1.getChildren().setAll(root);
    }
}
