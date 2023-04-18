package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class Singleton {
    private static final Logger log = LogManager.getLogger();
    private static WebDriver driver;

    private Singleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            BrowserFactory browserFactory = new BrowserFactory();
            driver = browserFactory.getWebDriver(BrowserFactory.Browser.CHROME);
        }
        return driver;
    }

    public static void closeWebBrowser() {
        if (driver != null) {
            log.info("Closing browser");
            driver.quit();
        }
    }
}