package forms.app;

import forms.base.BaseForm;
import forms.base.Button;
import org.openqa.selenium.By;


public class MainPage extends BaseForm {
    private static final String name = "MainPage";
    private static final By locator = By.xpath("//img[@src='/images/Toolsqa.jpg']");
    private final Button btnAlertFrameWindows = new Button(By.xpath("//div[@class='card-body']//h5[contains(text(),'Alerts, Frame & Windows')]"), "Button Alert Frame Windows");
    private final Button btnElements = new Button(By.xpath("//div[@class='card-body']//h5[contains(text(),'Elements')]"), "Button Elements");

    public MainPage() {
        super(locator, name);
    }

    public void clickBtnAlertFrameWindows() {
        btnAlertFrameWindows.click();
    }

    public void clickBtnElements() {
        btnElements.click();
    }
}