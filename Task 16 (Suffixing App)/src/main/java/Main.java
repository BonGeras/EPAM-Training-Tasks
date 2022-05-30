import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = args[0];
        Reader reader = new Reader(filePath);
        Properties properties = reader.readData();
        ConfigurationOperations configurationOperations = new ConfigurationOperations(properties);
        configurationOperations.change();
    }

}
