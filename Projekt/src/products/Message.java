package products;

import java.io.Serializable;

/**
 * Basic type of message to inform reader that his book was accepted
 */
public class Message implements Serializable {
    //atributes
    private final String info;

    /**
     * creates a message with initial text
     * @param info a etxt of the message
     */
    public Message(String info) {
        this.info = info;
    }

    /**
     * @return text of the message
     */
    public String getInfo() {
        return info;
    }
}
