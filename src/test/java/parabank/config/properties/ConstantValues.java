package parabank.config.properties;

import java.io.File;
import java.util.Properties;

public class ConstantValues {
    public final static String TEST_ENVIRONMENT = PropertiesHandler.getTestEnvironment();
    public final static String PROJECT_NAME = PropertiesHandler.getProjectName();
    public final static Long TIMEOUT = Long.valueOf(PropertiesHandler.getSelenideTimeout());
    public final static String BROWSER = PropertiesHandler.getSelenideBrowser();
    public final static String SELENIDE_REMOTE = PropertiesHandler.getSelenideRemote();
    public final static Boolean BROWSER_MAXIMIZED = PropertiesHandler.getSelenideStartMaximized();
    public final static String DOWNLOAD_PATH = PropertiesHandler.getSelenideDownloadPath() + File.separator + "TEMP";
    public final static String TEST_URL = String.format(PropertiesHandler.getTestUrl());


    public final static String DATA_PATH = String.format(PropertiesHandler.getDataPath(), PROJECT_NAME, TEST_ENVIRONMENT.toUpperCase());
    public final static String DATA_USER_CREATION_PATH = String.format(PropertiesHandler.getUserCreationPath(), PROJECT_NAME, TEST_ENVIRONMENT.toUpperCase());
    public final static String USERS_PATH =  String.format(PropertiesHandler.getUsersPath(), PROJECT_NAME, TEST_ENVIRONMENT.toUpperCase());
    public final static String USERS_DEFAULT_FILENAME = PropertiesHandler.getUsersDefaultFileName();
    public final static String ATTACHMENT_PATH =  String.format(PropertiesHandler.getAttachmentPath(), PROJECT_NAME);
}
