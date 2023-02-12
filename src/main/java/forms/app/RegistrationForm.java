package forms.app;

import forms.base.BaseForm;
import forms.base.Button;
import forms.base.TextBox;
import org.openqa.selenium.By;

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
        super(locator, name);
    }

    public void typeTextFirstName(String name) {

        txbFirstName.typeText(name);
    }

    public void typeTextLastName(String lastName) {

        txbLastName.typeText(lastName);
    }

    public void typeTextEmail(String email) {

        txbEmail.typeText(email);
    }

    public void typeAge(String age) {

        txbAge.typeText(age);
    }

    public void typeSalary(String salary) {

        txbSalary.typeText(salary);
    }

    public void typeDepartment(String department) {

        txbDepartment.typeText(department);
    }

    public void clickSubmit() {

        btnSubmit.click();
    }
}