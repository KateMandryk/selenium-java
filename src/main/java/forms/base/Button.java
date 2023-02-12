package forms.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


public class Button extends BaseElement {
    private By locator;
    private String name;

    public Button(By locator, String name) {
        super(locator, name);
    }

}