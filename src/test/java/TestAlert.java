
import org.testng.Assert;
import org.testng.annotations.Test;
import forms.app.AlertsPage;
import forms.app.AlertsFrameWindowsPage;
import forms.app.MainPage;
import forms.app.Menu;
import utils.FileReaderUtils;
import utils.Browser;


public class TestAlert extends BaseTest {
    private final FileReaderUtils readerUtils=new FileReaderUtils();
    private final String alertClickButton=readerUtils.getValue("AlertMassageClickButton");
    private final String alertMassageConfirmAction=readerUtils.getValue("AlertMassageConfirmAction");
    private final String message=readerUtils.getValue("Massage");
    private final String alertMassageEnterName=readerUtils.getValue("AlertMassageEnterName");

    @Test
    public void testAlert()  {
        MainPage mainPage=new MainPage();
        Assert.assertTrue(mainPage.isDisplayed(), "Page is not open");
        mainPage.clickBtnAlertFrameWindows();
        AlertsFrameWindowsPage alertsWindows=new AlertsFrameWindowsPage();
        Assert.assertTrue(alertsWindows.isDisplayed(),"Page is not open");
        Menu menu=new Menu();
        menu.clickBtnAlert();
        AlertsPage alerts=new AlertsPage();
        Assert.assertTrue(alerts.isDisplayed(),"Page is not open");
        alerts.clickBtnAlert();
        Assert.assertEquals(Browser.getTextAlert(),alertClickButton,"Alert with massage\"You clicked a button\" is not open");
        Browser.acceptAlert();
        alerts.clickBtnConfirm();
        Assert.assertEquals(Browser.getTextAlert(),alertMassageConfirmAction,"Alert with massage\"Do you confirm action?\" is not open");
        Browser.acceptAlert();
        Assert.assertEquals(alerts.getTextConfirmResult(),message,"Massage\"You selected Ok\" is not present  on the page");
        alerts.clickBtnPrompt();
        Assert.assertEquals(Browser.getTextAlert(),alertMassageEnterName,"Alert with massage\"Please enter your name\" is not open");
        String actualMassage=Browser.typeTextToAlert();
        Browser.acceptAlert();
        Assert.assertEquals(alerts.getTextPromptResult(),"You entered "+ actualMassage,"Massage is not presented on the page or massage content does not match the entered massage ");


    }

}
