package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

public class LoginPage {
    WebDriver driver;
    WaitUtils waitUtils;

    By email = By.xpath("//input[@id='field-email']");
    By password = By.xpath("//input[@id='field-password']");
    By signIn = By.xpath("//button[text()='Sign In']");
    By errormsg=By.xpath("//div[text()='Invalid email or password']");
    public LoginPage(WebDriver driver){//constructor
        this.driver=driver;
        this.waitUtils= new WaitUtils(driver);
    }

    public void enterEmail(String emailID ){
        waitUtils.waitForVisibility(email).sendKeys(emailID);
    }

    public void enterPassword(String pass){
        waitUtils.waitForVisibility(password).sendKeys(pass);
    }

    public void clickSignIn(){
        waitUtils.waitForClickability(signIn).click();
    }
    public String errorMessage(){
        String errormsgprint=waitUtils.waitForVisibility(errormsg).getText();
        return errormsgprint;
    }
}

