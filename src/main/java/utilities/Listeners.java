package utilities;

import java.io.File;
import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {




    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test " + result.getName() + " successfully executed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test "+result.getName()+" Failed");
        String testName = result.getName();
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseClass)currentClass).getDriver();
        if (driver != null) {
            try {
                File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrfile, new File( "screenshots/"+ testName + ".png"));
                System.out.println("Screenshot taken");
            } catch (IOException e) {
                System.err.println("Unable to take screenshot");
                e.printStackTrace();
            }
        }
    }


}
