package forms.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import forms.base.BaseForm;
import utils.Singleton;

import static utils.Singleton.getWebDriverInstance;

public class NestedFramesPage extends BaseForm {
    private static final By locator = By.className("main-header");
    private static final String name = "Nested Frames";
    private final By iframe = By.cssSelector("body > iframe");
    private final By frame = By.id("frame1");
    private final By messageFrame = By.xpath("//*[contains(text(),'Parent frame')]");
    private final By messageIframe = By.xpath("//*[contains(text(),'Child Iframe')]");

    public NestedFramesPage() {
        super(locator, name);
    }

    public String getMassageParentFrame() {
        WebElement parentFrame = getWebDriverInstance().findElement(frame);
        getWebDriverInstance().switchTo().frame(parentFrame);
        return getWebDriverInstance().findElement(messageFrame).getText();

    }

    public String getMassageChildFrame() {
        WebElement childIframe = getWebDriverInstance().findElement(iframe);
        getWebDriverInstance().switchTo().frame(childIframe);
        return getWebDriverInstance().findElement(messageIframe).getText();
    }
}