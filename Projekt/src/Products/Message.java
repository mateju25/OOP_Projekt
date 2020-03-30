package Products;

import java.io.Serializable;

public class Message implements Serializable {
    private String info;

    public Message(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
