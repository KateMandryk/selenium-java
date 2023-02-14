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
        log.info("Step 1 :: Navigate to main page");
        MainPage mainPage=new MainPage();
        Assert.assertTrue(mainPage.isDisplayed(), "MainPage is not open");
        log.info("Step 2 ::click button Alerts, Frame & Windows, navigate to Alerts, Frame & Windows Page");
        mainPage.clickBtnAlertFrameWindows();
        AlertsFrameWindowsPage alertsWindowsPage=new AlertsFrameWindowsPage();
        Assert.assertTrue(alertsWindowsPage.isDisplayed(),"AlertsWindowsPage is not open");
        log.info("Step 3 :: Navigate to left menu and click button Nested Frames");
        Menu menu=new Menu();
        menu.clickBtnNestedFrames();
        log.info("Step 4 :: Navigate to Nested Frames page and get text from frames");
        NestedFramesPage nestedFramesPage=new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isDisplayed(), "NestedFramesPage is not open");
        Assert.assertEquals(nestedFramesPage.getMassageParentFrame(),messageFrame, "Element is not presented");
        Assert.assertEquals(nestedFramesPage.getMassageChildFrame(), messageIframe,"Element is not presented");
        Browser.backFromFrame();
        log.info("Step 5 :: Navigate to left menu and click button Frames");
        menu.clickBtnFrames();
        log.info("Step 6 :: Navigate to Frames page and check messages from iframes");
        FramesPage framesPage= new FramesPage();
        Assert.assertTrue(framesPage.isDisplayed(), "FramesPage is not open");
        Assert.assertEquals(framesPage.getTextLowerCase(),framesPage.getTextUpperCase());
    }
}