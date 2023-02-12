package forms.app;

import org.openqa.selenium.By;
import forms.base.BaseForm;
import forms.base.Button;

public class BrowserWindowsPage extends BaseForm {
    private static By locator=By.className("main-header");
    private static String name="BrowserWindowsPage";
    private Button btnTab=new Button(By.id("tabButton"),"Button tab");


    public BrowserWindowsPage() {
       super(locator,name);
    }

    public void clickTabButton(){
        btnTab.click();

    }


}
