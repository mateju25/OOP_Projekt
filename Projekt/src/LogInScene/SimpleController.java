package LogInScene;

import Library.Office;
import com.sun.deploy.nativesandbox.comm.Request;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SimpleController {
    //atributes
    protected Office lib;

    //methods
    public void transferData(Office paLib)
    {
        this.lib = paLib;
    }
    public void switchScene(String s, ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader((getClass().getResource(s)));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //toto este prekopat do finalnej verzie
        switch (s)
        {
            case ("logInScene.fxml") : {
                LogInController controller = loader.getController();
                controller.transferData(this.lib);
                break;
            }
            case ("logOutSceneClient.fxml") : {
                LogOutController controller = loader.getController();
                controller.transferData(this.lib);
                break;
            }
            case ("logOutSceneLibrarian.fxml") : {
                LogOutController controller = loader.getController();
                controller.transferData(this.lib);
                break;
            }
            case ("registerScene.fxml") : {
                RegisterSceneController controller = loader.getController();
                controller.transferData(this.lib);
                break;
            }
            case ("requestScene.fxml") : {
                RequestController controller = loader.getController();
                controller.transferData(this.lib);
                break;
            }
            default: break;
        }

        Scene scene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}
