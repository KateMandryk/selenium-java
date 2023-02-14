
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
        log.info("Step 1 :: Navigate to main page");
        MainPage mainPage=new MainPage();
        Assert.assertTrue(mainPage.isDisplayed(), "Page is not open");
        mainPage.clickBtnAlertFrameWindows();
        log.info("Step 2 :: Navigate to main page Alerts, Frame & Windows Page");
        AlertsFrameWindowsPage alertsFrameWindowsPage=new AlertsFrameWindowsPage();
        Assert.assertTrue(alertsFrameWindowsPage.isDisplayed(),"Page is not open");
        Menu menu=new Menu();
        log.info("Step 3 :: Navigate to left menu and click button Alerts");
        menu.clickBtnAlert();
        log.info("Step 4 :: Navigate to Alerts Page");
        AlertsPage alerts=new AlertsPage();
        Assert.assertTrue(alerts.isDisplayed(),"Page is not open");
        log.info("Step 5 :: Click button Alert and accept alert");
        alerts.clickBtnAlert();
        Assert.assertEquals(Browser.getTextAlert(),alertClickButton,"Alert with massage\"You clicked a button\" is not open");
        Browser.acceptAlert();
        log.info("Step 6 :: Click button Confirm and accept alert");
        alerts.clickBtnConfirm();
        Assert.assertEquals(Browser.getTextAlert(),alertMassageConfirmAction,"Alert with massage\"Do you confirm action?\" is not open");
        Browser.acceptAlert();
        Assert.assertEquals(alerts.getTextConfirmResult(),message,"Massage\"You selected Ok\" is not present  on the page");
        log.info("Step 7 :: Click button Prompt and type message to alert, accept alert");
        alerts.clickBtnPrompt();
        Assert.assertEquals(Browser.getTextAlert(),alertMassageEnterName,"Alert with massage\"Please enter your name\" is not open");
        String actualMassage=Browser.typeTextToAlert();
        Browser.acceptAlert();
        Assert.assertEquals(alerts.getTextPromptResult(),"You entered "+ actualMassage,"Massage is not presented on the page or massage content does not match the entered massage ");
    }
}