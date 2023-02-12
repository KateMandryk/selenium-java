import org.testng.Assert;
import org.testng.annotations.Test;
import forms.app.*;
import utils.FileReaderUtils;
import utils.Browser;


public class TestIframe extends BaseTest {
    private final FileReaderUtils readerUtils=new FileReaderUtils();
    private final String messageFrame=readerUtils.getValue("Frame");
    private final String messageIframe=readerUtils.getValue("IFrame");

    @Test
    public void testIframe() {
        MainPage mainPage=new MainPage();
        Assert.assertTrue(mainPage.isDisplayed(), "MainPage is not open");
        mainPage.clickBtnAlertFrameWindows();
        AlertsFrameWindowsPage alertsWindowsPage=new AlertsFrameWindowsPage();
        Assert.assertTrue(alertsWindowsPage.isDisplayed(),"AlertsWindowsPage is not open");
        Menu menu=new Menu();
        menu.clickBtnNestedFrames();
        NestedFramesPage nestedFramesPage=new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isDisplayed(), "NestedFramesPage is not open");
        Assert.assertEquals(nestedFramesPage.getMassageParentFrame(),messageFrame, "Element is not presented");
        Assert.assertEquals(nestedFramesPage.getMassageChildFrame(), messageIframe,"Element is not presented");
        Browser.backFromFrame();
        menu.clickBtnFrames();
        FramesPage framesPage= new FramesPage();
        Assert.assertTrue(framesPage.isDisplayed(), "FramesPage is not open");
        Assert.assertEquals(framesPage.getTextLowerCase(),framesPage.getTextUpperCase());
    }
}