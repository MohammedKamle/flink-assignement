package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    protected String URL = readConfig.getApplicationURL();
    protected ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeTest
    public void setUp(@Optional("chrome") String browser){
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();
            webDriverThreadLocal.set(new ChromeDriver());
        }else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
           // driver = new EdgeDriver();
            webDriverThreadLocal.set(new EdgeDriver());
        }else {
            WebDriverManager.chromedriver().setup();
           // driver = new ChromeDriver();
            webDriverThreadLocal.set(new ChromeDriver());
        }
        webDriverThreadLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriverThreadLocal.get().manage().window().maximize();
        webDriverThreadLocal.get().get(URL);
    }


    @AfterTest
    public void tearDown(){
        webDriverThreadLocal.get().quit();
    }

    public WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

}
