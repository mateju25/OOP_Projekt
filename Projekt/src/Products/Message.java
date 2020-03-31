package Products;

import java.io.Serializable;

public class Message implements Serializable {
    //atributes
    private String info;

    //constructor
    public Message(String info) {
        this.info = info;
    }

    //getters
    public String getInfo() {
        return info;
    }
}
