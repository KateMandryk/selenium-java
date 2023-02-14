import org.testng.Assert;
import org.testng.annotations.Test;
import forms.app.*;
import utils.Browser;

public class TestHandles extends BaseTest {

    @Test
    public void testHandles()  {
        log.info("Step 1 :: Navigate to main page");
        MainPage mainPage=new MainPage();
        Assert.assertTrue(mainPage.isDisplayed(), "MainPage is not open");
        log.info("Step 2 ::Click button Alert, Frame & Windows, navigate to Alert, Frame & Windows page");
        mainPage.clickBtnAlertFrameWindows();
        AlertsFrameWindowsPage alertsWindowsPage=new AlertsFrameWindowsPage();
        Assert.assertTrue(alertsWindowsPage.isDisplayed(),"AlertsWindowsPage is not open");
        log.info("Step 3 :: Navigate to left menu and click button Browser Windows");
        Menu menu=new Menu();
        menu.clickBtnBrowserWindows();
        log.info("Step 4 :: Navigate to Browser Windows page");
        BrowserWindowsPage browserWindowsPage=new BrowserWindowsPage();
        Assert.assertTrue(browserWindowsPage.isDisplayed(), "BrowserWindowsPage is not open");
        log.info("Step 5 ::Click button New Tab, navigate to tab Sample page");
        browserWindowsPage.clickTabButton();
        SamplePage samplePage=new SamplePage();
        Browser.goToTab();
        Assert.assertEquals(samplePage.isFormOpen(),samplePage.getName(),"Sample page is not open");
        log.info("Step 6 ::Close tab Sample page");
        Browser.closeTab();
        Assert.assertTrue(browserWindowsPage.isDisplayed(), "Sample page was not close");
        log.info("Step 7 :: Navigate to left menu and click button Elements");
        menu.clickBtnElements();
        ElementsPage elements=new ElementsPage();
        log.info("Step 8 :: Click button Links, navigate to Links Page");
        elements.clickBtnLinks();
        LinksPage linksPage=new LinksPage();
        Assert.assertTrue(linksPage.isDisplayed(), "LinksPage is not open");
        linksPage.clickLnkHome();
        log.info("Step 8 :: Click link Home, navigate to tab Main page");
        Browser.goToTab();
        Assert.assertTrue(mainPage.isDisplayed(), "Main Page is not open");
    }
}
