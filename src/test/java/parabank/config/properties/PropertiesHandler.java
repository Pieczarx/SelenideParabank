package parabank.config.properties;

import lombok.SneakyThrows;
import parabank.config.util.ResourceHelper;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
    public static final String CONFIG_FILE = "config.file";
    public static final String DEFAULT_CONFIG_FILENAME = "main.properties";
    public static boolean alreadyInitialized = false;

    public static String getProjectName() {
        return getEnvironmentProperty("project.name");
    }

    public static String getTestUrl() {
        return getEnvironmentProperty("test.URL");
    }
    public static String getSelenideBrowser() {
        return getEnvironmentProperty("selenide.browser");
    }
    public static Boolean getSelenideStartMaximized() {
        return Boolean.valueOf(getEnvironmentProperty("selenide.startMaximized"));
    }

    public static String getSelenideTimeout() {
        return getEnvironmentProperty("selenide.timeout");
    }

    public static String getSelenideDownloadPath() {
        if (getEnvironmentProperty("selenide.downloadPath") != null) {
            return getEnvironmentProperty("selenide.downloadPath");
        } else {
            return System.getProperty("user.dir");
        } }

    public static String getSelenideRemote() {
        return getEnvironmentProperty("selenide.remote");
    }



    @SneakyThrows
    private static String getEnvironmentProperty(String key) {
        if(!alreadyInitialized) init();
        return System.getProperty(key);
    }

    private static synchronized void init() throws LoadingPropertiesException {
        alreadyInitialized = true;
        String propertiesFileName = (System.getProperty(CONFIG_FILE) !=null) ? System.getProperty(CONFIG_FILE) : DEFAULT_CONFIG_FILENAME;
        System.out.println("Loading properties: " + propertiesFileName);
        try {
            Properties properties = new Properties();
            properties.load(ResourceHelper.getResourceAsInputStream(propertiesFileName));
            for (String key : properties.stringPropertyNames()) {
                if (System.getProperty(key) == null) {
                    System.setProperty(key, properties.getProperty(key));
                }
            }
        } catch (IOException | NullPointerException e) {
            throw  new LoadingPropertiesException("Failed to load a configuration from the file " + propertiesFileName + "\n"
                    + "Maybe you don't have " + propertiesFileName + "file in resources?");
        }
    }
}
