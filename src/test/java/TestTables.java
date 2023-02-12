import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import forms.app.ElementsPage;
import forms.app.MainPage;
import forms.app.RegistrationForm;
import forms.app.WebTablesPage;
import utils.FileReaderUtils;

import java.io.IOException;


public class TestTables extends BaseTest {

    @DataProvider(name = "User")
    public static Object[][] getData() {
        FileReaderUtils reader = new FileReaderUtils();
        int indexUser1 = 0;
        int indexUser2 = 1;
        return new Object[][]{
                {reader.getUser().get(indexUser1).getName(),
                        reader.getUser().get(indexUser1).getLastName(),
                        reader.getUser().get(indexUser1).getEmail(),
                        reader.getUser().get(indexUser1).getAge(),
                        reader.getUser().get(indexUser1).getSalary(),
                        reader.getUser().get(indexUser1).getDepartment()
                },
                {reader.getUser().get(indexUser2).getName(),
                        reader.getUser().get(indexUser2).getLastName(),
                        reader.getUser().get(indexUser1).getEmail(),
                        reader.getUser().get(indexUser2).getAge(),
                        reader.getUser().get(indexUser2).getSalary(),
                        reader.getUser().get(indexUser2).getDepartment()
                }
        };
    }

    @Test(dataProvider = "User")
    public void testTables(String name, String lastName, String email, String age, String salary, String department) throws IOException {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isDisplayed(), "Main Page is not opened");
        mainPage.clickBtnElements();
        ElementsPage elementsPage = new ElementsPage();
        Assert.assertTrue(elementsPage.isDisplayed(), "Elements Page is not open");
        elementsPage.clickBtnWebTables();
        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isDisplayed(), "WebTables Page is not opened");
        webTablesPage.clickButtonAdd();
        RegistrationForm form = new RegistrationForm();
        Assert.assertTrue(form.isDisplayed(), "Registration Form is not opened");
        form.typeTextFirstName(name);
        form.typeTextLastName(lastName);
        form.typeTextEmail(email);
        form.typeAge(age);
        form.typeSalary(salary);
        form.typeDepartment(department);
        form.clickSubmit();
        int numberOfUsers = webTablesPage.getNumberOfUsers();
        String userName = webTablesPage.getTable().get(3).getName();
        Assert.assertEquals(webTablesPage.getTable().get(3).getName(), name, "FirstName has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(3).getLastName(), lastName, "LastName has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(3).getAge(), age, "Email has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(3).getEmail(), email, "Age has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(3).getSalary(), salary, "Salary has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(3).getDepartment(), department, "Department has not appeared in a table");
        webTablesPage.clickButtonDelete();
        Assert.assertNotEquals(numberOfUsers, webTablesPage.getNumberOfUsers(), "After deleting a user, the number of records in the table has not changed.");
        Assert.assertNotEquals(webTablesPage.getTable().get(3).getName(), userName, "User information has not deleted");

    }


}
