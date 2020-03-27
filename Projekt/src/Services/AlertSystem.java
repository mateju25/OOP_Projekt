package Services;

import javafx.scene.control.Alert;

public class AlertSystem {
    public AlertSystem(String paTitle, String paMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(paTitle);
        alert.setHeaderText(null);
        alert.setContentText(paMessage);
        alert.showAndWait();
    }
}
