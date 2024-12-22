package TestBase;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public Properties properties;
    public FileInputStream ip;

    public TestBase() throws Exception {
        properties = new Properties();
        ip = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\POM_ShoppingCartPage\\src\\main\\java\\Config\\config.properties");
        properties.load(ip);
    }

    public WebDriver initializeBrowser(String browser) {

        if (browser.equals(properties.getProperty("browser"))) {
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
            driver = new ChromeDriver(options);
        } else if (browser.equals(properties.getProperty("secondaryBrowser"))) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equals(properties.getProperty("tertiaryBrowser"))) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
        driver.get(properties.getProperty("url"));

        return driver;
    }

}
