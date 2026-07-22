package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ScreenshotUtils;

import java.io.IOException;

public class LoginPageWithTestng extends BaseTest {
    LoginPage loginPage;
    ConfigReader config = new ConfigReader();
    /*By username = By.xpath("//input[@name='username']");
   By password = By.xpath("//input[@name='password']");
   By Login = By.xpath("//button[@type='submit']");*/

    /*public LoginwithTestng() throws IOException {
    }*/
    @Test(priority = 1)
    public void SignIn(){
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(config.getEmail());
        loginPage.enterPassword(config.getPassword());
        loginPage.clickSignIn();

    }
    @Test(priority = 2)
    public void unsuccessfullSignIn() {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("abc@gmail.com");
        loginPage.enterPassword("Abcdef");
        loginPage.clickSignIn();
        String actualerrormsg=loginPage.errorMessage();
        Assert.assertEquals(actualerrormsg,"Invalid email or password");

    }


}

