package forms.app;

import org.openqa.selenium.By;
import forms.base.BaseForm;
import forms.base.Button;
import forms.base.TextBox;

public class RegistrationForm extends BaseForm {
    private static final By locator = By.id("registration-form-modal");
    private static final String name = "Registration Form";
    private final TextBox txbFirstName = new TextBox(By.id("firstName"), "TextBox First Name");
    private final TextBox txbLastName = new TextBox(By.id("lastName"), "TextBox Last Name");
    private final TextBox txbEmail = new TextBox(By.id("userEmail"), "TextBox email");
    private final TextBox txbAge = new TextBox(By.id("age"), "TextBox Age");
    private final TextBox txbSalary = new TextBox(By.id("salary"), "TextBox Salary");
    private final TextBox txbDepartment = new TextBox(By.id("department"), "TextBox Department");
    private final Button btnSubmit = new Button(By.id("submit"), "Button Submit");

    public RegistrationForm() {
        super(locator,name);
    }

    public void typeTextFirstName(String params1) {

        txbFirstName.typeText(params1);
    }

    public void typeTextLastName(String params2) {

        txbLastName.typeText(params2);
    }

    public void typeTextEmail(String params3) {

        txbEmail.typeText(params3);
    }

    public void typeAge(String params4) {

        txbAge.typeText(params4);
    }

    public void typeSalary(String params5) {

        txbSalary.typeText(params5);
    }

    public void typeDepartment(String params6) {

        txbDepartment.typeText(params6);
    }

    public void clickSubmit() {

        btnSubmit.click();
    }
}