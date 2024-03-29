package forms.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utils.Singleton.getWebDriverInstance;


public abstract class BaseForm {
    private final By locator;
    private final String name;

    protected BaseForm(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String isFormOpen() {
        WebElement element = getWebDriverInstance().findElement(locator);
        String Label = element.getText();
        return Label;
    }

    public boolean isDisplayed() {
        WebElement element = getWebDriverInstance().findElement(locator);
        return element.isDisplayed();

    }
}