package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ScreenshotUtils;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ConfigReader config = new ConfigReader();
        driver.get(config.getUrl());
    }

    @AfterMethod
    public void closeApp() {

            driver.quit();

    }
}
