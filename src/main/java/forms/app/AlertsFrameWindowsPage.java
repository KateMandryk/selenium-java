package forms.app;

import org.openqa.selenium.By;
import forms.base.BaseForm;


public class AlertsFrameWindowsPage extends BaseForm {
    private static final By locator = By.xpath("//div[contains(@class,'main-header') and contains(text(),'Alerts, Frame & Windows')]");
    private static final String name = "Alerts Windows Page";

    public AlertsFrameWindowsPage() {
       super(locator,name);
    }
}