package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;
import utils.ScreenshotUtils;

public class TestListeners implements ITestListener {
    ExtentReports extent = ExtentReportManager.getInstance();
    ExtentTest test;


    @Override
    public void onTestStart(ITestResult result){
        test=extent.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        test.pass("Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtils.capturescreenShot(BaseTest.driver,result.getMethod().getMethodName());
        test.addScreenCaptureFromPath(path);
        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
