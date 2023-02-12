package forms.app;

import org.openqa.selenium.By;
import forms.base.BaseForm;

public class SamplePage extends BaseForm {
    private static By locator = By.id("sampleHeading");
    private static String name = "This is a sample page";

    public SamplePage() {
        super(locator,name);

    }
}


