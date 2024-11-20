package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentConfig {

    private static Properties properties = new Properties();

    static {
        // Get environment from system properties (default to 'local' if not set)
        String env = System.getProperty("env", "local");

        // Load the properties file for the specified environment
        try (FileInputStream inputStream = new FileInputStream("src/test/resources/config/config-" + env + ".properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

}
