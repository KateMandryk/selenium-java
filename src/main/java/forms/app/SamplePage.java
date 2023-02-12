package forms.app;

import forms.base.BaseForm;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {
    private static final By locator = By.id("sampleHeading");
    private static final String name = "This is a sample page";

    public SamplePage() {
        super(locator, name);
    }
}


