package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtils {
    WebDriver driver;
    public ScreenshotUtils(WebDriver driver){
        this.driver= driver;
    }

    public void capturescreenShot(String filename) throws Exception{
        TakesScreenshot ts =(TakesScreenshot) driver;
        File sourcefile = ts.getScreenshotAs(OutputType.FILE);
        File targetfile = new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+".png");

        sourcefile.renameTo(targetfile);
    }

}
