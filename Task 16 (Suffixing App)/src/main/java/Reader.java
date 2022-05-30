import java.io.FileReader;
import java.util.Properties;

public class Reader {
    private final String filePath;

    public Reader(String filePath) {
        this.filePath = filePath;
    }

    public Properties readData () throws Exception {
        FileReader reader = new FileReader(filePath);
        Properties properties = new Properties();
        properties.load(reader);
        return properties;
    }
}
