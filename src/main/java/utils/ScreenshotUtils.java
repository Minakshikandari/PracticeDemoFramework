package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtils {
    WebDriver driver;
    public ScreenshotUtils(WebDriver driver){
        this.driver= driver;
    }

    public static String capturescreenShot(WebDriver driver, String testname){
        String path= System.getProperty("user.dir")+"/screenshots/"+testname+".png";
        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            Files.copy(srcfile.toPath(),new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}
