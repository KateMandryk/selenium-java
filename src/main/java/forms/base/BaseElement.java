package forms.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigFileReader;
import utils.Singleton;

import java.util.List;

import static utils.Singleton.getWebDriverInstance;


public abstract class BaseElement {
    private final By locator;
    private final String name;
    private final Logger log = LogManager.getLogger();
    private final ConfigFileReader configFileReader = new ConfigFileReader();

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public WebElement getElement() {
        WebElement element = getWebDriverInstance().findElement(locator);
        WebElement myElement = new WebDriverWait(getWebDriverInstance(), configFileReader.getDefaultTimeOut()).until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) getWebDriverInstance()).executeScript("arguments[0].scrollIntoView();", myElement);
        return element;
    }

    public void click() {
        log.info(name+ ":: Clicking");
        getElement().click();
    }

    public void typeText(String text) {
        log.info(name+ ":: Typing "+ text);
        getElement().sendKeys(text);

    }

    public String getText() {
        log.info(name + ":: Getting text from element");
        return getElement().getText();
    }

    public int getNumberOfElements() {
        log.info(name + ":: Getting number of element");
        List<WebElement> element = getWebDriverInstance().findElements(locator);
        return element.size();
    }
}