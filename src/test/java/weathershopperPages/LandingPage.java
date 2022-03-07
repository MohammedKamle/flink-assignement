package weathershopperPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utilities;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "temperature")
    private WebElement temperatureIndicator;

    @FindBy(xpath = "//*[contains(text(), 'moisturizers')]")
    private WebElement buyMoisturizer;

    @FindBy(xpath = "//*[contains(text(), 'sunscreens')]")
    private WebElement buySunscreen;


    public void clickOnBuyMoisturizer(){
        buyMoisturizer.click();
    }

    public void clickOnBuySunscreen(){
        buySunscreen.click();
    }

    public int getTheTemperature(){
        return Utilities.extractInteger(temperatureIndicator.getText());
    }


}
