import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigurationOperations {
    private final Properties properties;
    private static final Logger logger = Logger.getLogger("ConfigurationOperations");

    public ConfigurationOperations(Properties properties) {
        this.properties = properties;
    }

    public boolean isExist(String parameter) {
        return properties.getProperty(parameter) == null;
    }

    public void change() {
        if (!(properties.getProperty("mode").equalsIgnoreCase("copy")) &&
                !(properties.getProperty("mode").equalsIgnoreCase("move"))) {
            logger.log(Level.SEVERE, "Mode is not recognized: " + properties.getProperty("mode"));
            return;
        } else if (isExist("suffix") || properties.getProperty("suffix").equals("")) {
            logger.log(Level.SEVERE, "No suffix is configured");
            return;
        } else if (isExist("files") || properties.getProperty("files").equals("")) {
            logger.log(Level.WARNING, "No files are configured to be copied/moved");
            return;
        }
        ArrayList<String> filePaths = getFiles(properties.getProperty("files"));
        for (String path : filePaths) {
            File file = new File(path);
            if (!file.exists()) {
                logger.log(Level.SEVERE, "No such file: " + path);
                continue;
            }
            if (properties.getProperty("mode").equalsIgnoreCase("copy")) {
                try {
                    Path newPath = Paths.get(pasteSuffix(path));
                    File newFile = new File(String.valueOf(newPath));
                    Files.copy(file.toPath(),
                            newFile.toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                    logger.log(Level.INFO, path + " -> " + pasteSuffix(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (properties.getProperty("mode").equalsIgnoreCase("move")) {
                try {
                    Path newPath = Paths.get(pasteSuffix(path));
                    File newFile = new File(String.valueOf(newPath));
                    Files.copy(file.toPath(),
                            newFile.toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                    logger.log(Level.INFO, path + " => " + pasteSuffix(path));
                    file.delete();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String pasteSuffix(String name) {
        String[] splitName = name.split("[.]");
        List<String> arrayName = new ArrayList<>(Arrays.asList(splitName));
        arrayName.add(1, properties.getProperty("suffix"));
        arrayName.add(2, ".");
        name = String.join("", arrayName);
        return name;
    }

    public ArrayList<String> getFiles(String filesPath) {
        String[] splitName = filesPath.split(":");
        return new ArrayList<>(Arrays.asList(splitName));
    }
}