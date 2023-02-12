import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import forms.app.MainPage;
import utils.ConfigFileReader;
import utils.Browser;
import utils.Random;
import utils.Singleton;

import static utils.Singleton.getWebDriverInstance;

public class BaseTest {
    private final Logger log = LogManager.getLogger();

    @BeforeMethod
    public void setUp() {
        ConfigFileReader reader = new ConfigFileReader();
        log.info("Browser ready...");
        getWebDriverInstance();
        Browser.getURL(reader.getUrl());
    }

    @AfterTest
    public void close() {
        Singleton.closeWebBrowser();
    }
}