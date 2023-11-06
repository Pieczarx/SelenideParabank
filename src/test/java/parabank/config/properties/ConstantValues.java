package parabank.config.properties;

import java.io.File;
import java.util.Properties;

public class ConstantValues {
    public final static String PROJECT_NAME = PropertiesHandler.getProjectName();
    public final static Long TIMEOUT = Long.valueOf(PropertiesHandler.getSelenideTimeout());
    public final static String BROWSER = PropertiesHandler.getSelenideBrowser();
    public final static String SELENIDE_REMOTE = PropertiesHandler.getSelenideRemote();
    public final static Boolean BROWSER_MAXIMIZED = PropertiesHandler.getSelenideStartMaximized();
    public final static String DOWNLOAD_PATH = PropertiesHandler.getSelenideDownloadPath() + File.separator + "TEMP";
    public final static String TEST_URL = String.format(PropertiesHandler.getTestUrl());
}
