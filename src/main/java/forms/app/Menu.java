package forms.app;

import forms.base.BaseForm;
import forms.base.Button;
import org.openqa.selenium.By;

public class Menu extends BaseForm {
    private final static String name = "Left menu";
    private final static By locator = By.className("menu-list");
    private final Button btnFrames = new Button(By.xpath("//span[contains(text(),'Frames')]"), "Button Frame");
    private final Button btnElements = new Button(By.xpath("//div[contains(@class,'header-text') and contains(text(),'Elements')]"), "Button Elements");
    private final Button btnAlert = new Button(By.xpath("//span[contains(@class,'text') and contains(text(),'Alerts')]"), "Button Alert");
    private final Button btnNestedFrames = new Button(By.xpath("//span[contains(@class,'text') and contains(text(),'Nested Frames')]"), "Button Nested Frames");
    private final Button btnBrowserWindows = new Button(By.xpath("//span[contains(text(),'Browser Windows')]"), "Button Browser Windows");

    public Menu() {
        super(locator, name);
    }


    public void clickBtnAlert() {
        btnAlert.click();
    }

    public void clickBtnNestedFrames() {
        btnNestedFrames.click();
    }

    public void clickBtnBrowserWindows() {
        btnBrowserWindows.click();
    }

    public void clickBtnElements() {
        btnElements.click();
    }

    public void clickBtnFrames() {
        btnFrames.click();
    }
}