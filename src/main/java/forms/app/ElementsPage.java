package forms.app;

import org.openqa.selenium.By;
import forms.base.BaseForm;
import forms.base.Button;

public class ElementsPage extends BaseForm {
    private static final By locator=By.className("main-header");
    private static final String name="Elements";
    private final Button btnWebTables =new Button(By.xpath("//*[@id='item-3']//*[text()='Web Tables']"),"Button Web Tables");
    private final Button btnLinks =new Button( By.xpath("//li[@id='item-5']//*[text()='Links']"),"Button Links");

    public ElementsPage() {
         super(locator,name);
    }

    public void clickBtnWebTables(){

        btnWebTables.click();
    }
    public void clickBtnLinks(){

        btnLinks.click();
    }
}