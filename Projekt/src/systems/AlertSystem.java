package systems;

import javafx.scene.control.Alert;

/**
 * System that manages alerts, when created creates a information window
 * @author Matej Delincak
 */
public class AlertSystem {
    /**
     * when created, creates a window with paTitle and paMessage
     * @param paTitle title of the window
     * @param paMessage message in the window
     */
    public AlertSystem(String paTitle, String paMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(paTitle);
        alert.setHeaderText(null);
        alert.setContentText(paMessage);
        alert.showAndWait();
    }
}
