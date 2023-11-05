package parabank.config.browser;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static parabank.config.properties.ConstantValues.*;
import static parabank.config.properties.ConstantValues.DOWNLOAD_PATH;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
public class Browser {

    public static void setUp() {
        if(BROWSER.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            Configuration.browserCapabilities = options;
            WebDriverManager.chromedriver().setup();


        }
        //different settings depends on the Selenide remote
        if(SELENIDE_REMOTE!=null) {
            //remote
            Configuration.fileDownload = FOLDER;
            Configuration.downloadsFolder = DOWNLOAD_PATH;

        } else {
            Configuration.fileDownload = FOLDER;
            Configuration.downloadsFolder = DOWNLOAD_PATH;

        }

    }

}
