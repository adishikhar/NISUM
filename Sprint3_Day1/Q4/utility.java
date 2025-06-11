package Q4;

import java.io.UncheckedIOException;
import java.io.IOException;

public class utility {
    public static String wrap() {
        try {
            return API.read();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

