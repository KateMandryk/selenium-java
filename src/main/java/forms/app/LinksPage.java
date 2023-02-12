package forms.app;

import org.openqa.selenium.By;
import forms.base.BaseForm;
import forms.base.Button;

public class LinksPage extends BaseForm {
    private static By locator = By.className("main-header");
    private static String name = "Links";
    private final Button btnHome = new Button(By.xpath("//*[@id='simpleLink']"), "link Home");


    public LinksPage() {
        super(locator,name);
    }

    public void clickLinkHome() {
        btnHome.click();
    }
}
