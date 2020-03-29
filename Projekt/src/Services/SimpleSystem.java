package Services;

import java.io.IOException;

public interface SimpleSystem {
    void serialize() throws ClassNotFoundException, IOException;
    void deserialize() throws ClassNotFoundException, IOException;
}
