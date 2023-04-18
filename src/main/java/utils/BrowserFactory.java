package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import static org.openqa.selenium.remote.BrowserType.*;

public class BrowserFactory {

    public enum Browser {
        CHROME,
        FIREFOX,
        EDGE,
        OPERA
    }

    private final ConfigFileReader configFileReader=new ConfigFileReader();

    public WebDriver getWebDriver(Browser browser){

        switch (browser){

            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case EDGE:
                WebDriverManager.edgedriver().setup();
               return new EdgeDriver();

            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver();

            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
}