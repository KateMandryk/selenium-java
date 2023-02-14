import forms.app.ElementsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import forms.app.MainPage;
import forms.app.RegistrationForm;
import forms.app.WebTablesPage;
import utils.FileReaderUtils;


public class TestTables extends BaseTest {
    private final int indexUser=3;

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
                        reader.getUser().get(indexUser2).getEmail(),
                        reader.getUser().get(indexUser2).getAge(),
                        reader.getUser().get(indexUser2).getSalary(),
                        reader.getUser().get(indexUser2).getDepartment()
                }
        };
    }

    @Test(dataProvider = "User")
    public void testTables(String name, String lastName, String email, String age, String salary, String department)  {
        log.info("Step 1 :: Navigate to main page");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isDisplayed(), "Main Page is not opened");
        log.info("Step 2 :: Click button Elements, navigate to Elements Page");
        mainPage.clickBtnElements();
        ElementsPage elementsPage = new ElementsPage();
        Assert.assertTrue(elementsPage.isDisplayed(), "Elements Page is not open");
        log.info("Step 3 :: Click button Web Table, navigate to Web Table page");
        elementsPage.clickBtnWebTables();
        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isDisplayed(), "WebTables Page is not opened");
        log.info("Step 4 :: Click button add, open Registration Form, add information in Registration Form");
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
        log.info("Step 5 :: Close form and check added information to the table on WebTables Page ");
        int numberOfUsers = webTablesPage.getNumberOfUsers();
        String userName = webTablesPage.getTable().get(indexUser).getName();
        Assert.assertEquals(webTablesPage.getTable().get(indexUser).getName(), name, "FirstName has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(indexUser).getLastName(), lastName, "LastName has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(indexUser).getAge(), age, "Email has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(indexUser).getEmail(), email, "Age has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(indexUser).getSalary(), salary, "Salary has not appeared in a table");
        Assert.assertEquals(webTablesPage.getTable().get(indexUser).getDepartment(), department, "Department has not appeared in a table");
        webTablesPage.clickButtonDelete();
        log.info("Step 6 ::Click button delete, delete added information to the table");
        Assert.assertNotEquals(numberOfUsers, webTablesPage.getNumberOfUsers(), "After deleting a user, the number of records in the table has not changed.");
        Assert.assertNotEquals(webTablesPage.getTable().get(indexUser).getName(), userName, "User information has not deleted");
    }
}