package forms.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import forms.base.BaseForm;
import utils.Singleton;

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
        WebElement parentFrame = Singleton.getWebDriverInstance().findElement(frame);
        Singleton.getWebDriverInstance().switchTo().frame(parentFrame);
        return Singleton.getWebDriverInstance().findElement(messageFrame).getText();

    }

    public String getMassageChildFrame() {
        WebElement childIframe = Singleton.getWebDriverInstance().findElement(iframe);
        Singleton.getWebDriverInstance().switchTo().frame(childIframe);
        return Singleton.getWebDriverInstance().findElement(messageIframe).getText();
    }
}