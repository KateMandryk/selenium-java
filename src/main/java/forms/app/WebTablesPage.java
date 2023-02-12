package forms.app;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import forms.base.*;
import utils.Singleton;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPage extends BaseForm {
    private static By locator = By.className("main-header");
    private static String name = "WebTables";
    private final By row = By.xpath("//div[@class='rt-tr-group']");
    private final By sell = By.xpath(".//div[@class='rt-td']");
    private final Button btnAdd = new Button(By.id("addNewRecordButton"), "Button Add");
    private final Button btnDelete = new Button(By.id("delete-record-4"), "Button Delete");
    private final TextBox numberOfUser = new TextBox(By.xpath("//div[@class='rt-td']//div[last()]"), "NumberOfUser");

    public WebTablesPage() {
        super(locator,name);
    }

   public void clickButtonAdd() {
        btnAdd.click();
    }

    public void clickButtonDelete() {
        btnDelete.click();
    }

    public int getNumberOfUsers() {
        return numberOfUser.getNumberOfElements();
    }

  public List<User> getTable() {
      List<User> testsTable = new ArrayList<>();
      List<WebElement> rowTable = Singleton.getWebDriverInstance().findElements(row);
      for (int i = 0; i < rowTable.size(); i++) {
          testsTable.add(i, createTable(rowTable.get(i)));
      }
      return testsTable;
  }

    public User createTable(WebElement row) {
        User user = new User();
        List<WebElement> cellTable = row.findElements(sell);
        user.setName(cellTable.get(0).getText());
        user.setLastName(cellTable.get(1).getText());
        user.setAge(cellTable.get(2).getText());
        user.setEmail(cellTable.get(3).getText());
        user.setSalary(cellTable.get(4).getText());
        user.setDepartment(cellTable.get(5).getText());
        return user;
    }
}