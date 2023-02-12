package forms.app;

import forms.base.BaseForm;
import forms.base.Button;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {
    private static final By locator = By.className("main-header");
    private static final String name = "Links";
    private final Button btnHome = new Button(By.id("simpleLink"), "link Home");


    public LinksPage() {
        super(locator, name);
    }

    public void clickLnkHome() {
        btnHome.click();
    }
}