package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class BrowserFactory {
    private final ConfigFileReader  configFileReader=new ConfigFileReader();

    public WebDriver getWebDriver(){

        switch (configFileReader.getBrowser().toUpperCase()){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
               return new ChromeDriver();

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "EDGE":
                WebDriverManager.edgedriver().setup();
               return new EdgeDriver();

            case "OPERA":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();

            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
}