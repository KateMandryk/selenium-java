import org.testng.Assert;
import org.testng.annotations.Test;
import forms.app.*;
import utils.Browser;

public class TestHandles extends BaseTest {


    @Test
    public void testHandles()  {

        MainPage mainPage=new MainPage();
        Assert.assertTrue(mainPage.isDisplayed(), "MainPage is not open");
        mainPage.clickBtnAlertFrameWindows();
        AlertsFrameWindowsPage alertsWindowsPage=new AlertsFrameWindowsPage();
        Assert.assertTrue(alertsWindowsPage.isDisplayed(),"AlertsWindowsPage is not open");
        Menu menu=new Menu();
        menu.clickBtnBrowserWindows();
        BrowserWindowsPage browserWindowsPage=new BrowserWindowsPage();
        Assert.assertTrue(browserWindowsPage.isDisplayed(), "BrowserWindowsPage is not open");
        browserWindowsPage.clickTabButton();
        SamplePage samplePage=new SamplePage();
        Browser.goToTab();
        Assert.assertEquals(samplePage.isFormOpen(),samplePage.getName(),"Sample page is not open");
        Browser.closeTab();
        Assert.assertTrue(browserWindowsPage.isDisplayed(), "Sample page was not close");
        menu.clickBtnElements();
        ElementsPage elements=new ElementsPage();
        elements.clickBtnLinks();
        LinksPage linksPage=new LinksPage();
        Assert.assertTrue(linksPage.isDisplayed(), "LinksPage is not open");
        linksPage.clickLnkHome();
        Browser.goToTab();
        Assert.assertTrue(mainPage.isDisplayed(), "MainPage is not open");
        Browser.goToTab();
        Assert.assertTrue(linksPage.isDisplayed(), "LinksPage is not open");
    }
}
