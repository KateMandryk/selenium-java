package forms.app;

import forms.base.BaseForm;
import forms.base.Button;
import forms.base.TextBox;
import org.openqa.selenium.By;

public class AlertsPage extends BaseForm {
    private final static String name = "Alerts";
    private final static By locator = By.xpath("//div[contains(@class,'main-header') and contains(text(),'Alerts')]");
    private final Button btnConfirm = new Button(By.id("confirmButton"), "Button confirm box will appear");
    private final Button btnAlert = new Button(By.id("alertButton"), "Button to see alert");
    private final Button btnPrompt = new Button(By.id("promtButton"), "Button prompt box will appear");
    private final TextBox promptResult = new TextBox(By.id("promptResult"), "Prompt Result");
    private final TextBox confirmResult = new TextBox(By.id("confirmResult"), "Confirm Result");

    public AlertsPage() {
        super(locator, name);
    }

    public void clickBtnAlert() {
        btnAlert.click();
    }

    public void clickBtnConfirm() {
        btnConfirm.click();
    }

    public String getTextConfirmResult() {

        return confirmResult.getText();
    }

    public void clickBtnPrompt() {

        btnPrompt.click();
    }

    public String getTextPromptResult() {

        return promptResult.getText();
    }
}