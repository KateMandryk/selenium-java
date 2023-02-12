package forms.app;

import org.openqa.selenium.By;
import forms.base.BaseForm;
import forms.base.TextBox;

public class FramesPage extends BaseForm {
    private static final By locator=By.className("main-header");
    private static final String name="Frames";
    private final TextBox txbFromUpperCase =new TextBox(By.xpath("//*[@id='frame1']"),"Massage from Upper Case");
    private final TextBox txbFromLowerCase =new TextBox(By.xpath("//*[@id='frame2']"),"Massage from Lower Case");

    public FramesPage() {
        super(locator,name);
    }

    public String getTextLowerCase() {

       return txbFromLowerCase.getText();
    }

    public String getTextUpperCase() {

        return txbFromUpperCase.getText();
    }

}




