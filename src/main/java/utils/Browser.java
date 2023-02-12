package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static utils.Singleton.getWebDriverInstance;


public class Browser {
    private static final Logger log = LogManager.getLogger();

    public static void getURL(String url) {
        log.info("Navigate to url - " + url);
        getWebDriverInstance().get(url);
    }
    public static void acceptAlert() {
        log.info("Alert :: Accept");
        getWebDriverInstance().switchTo().alert().accept();
    }

    public static String getTextAlert() {
        log.info("Alert :: Getting text");
        Alert alert = getWebDriverInstance().switchTo().alert();
        return alert.getText();
    }

    public static String typeTextToAlert() {
        log.info("Alert :: Typing text");
        String randomText = Random.randomString();
        getWebDriverInstance().switchTo().alert().sendKeys(randomText);
        return randomText;
    }

    public static void closeTab() {
        log.info("Browser:: Closing tab");
        ArrayList<String> tabs2 = new ArrayList<String>(getWebDriverInstance().getWindowHandles());
        getWebDriverInstance().switchTo().window(tabs2.get(1));
        getWebDriverInstance().close();
        getWebDriverInstance().switchTo().window(tabs2.get(0));

    }

    public static void backFromFrame() {
        getWebDriverInstance().switchTo().defaultContent();
    }

    public static void goToTab() {
        log.info("Navigate to tab");
        String originalWindow = getWebDriverInstance().getWindowHandle();
        assert getWebDriverInstance().getWindowHandles().size() != 1;
        Wait<WebDriver> wait = new FluentWait<>(getWebDriverInstance()).withMessage("Element was not found");
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : getWebDriverInstance().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                getWebDriverInstance().switchTo().window(windowHandle);
                break;
            }
        }
    }
}