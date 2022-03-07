package weathershopperPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Utilities;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[contains(text(), 'loe')]")
    private WebElement aloeVeraMoisturizer;

    @FindBy(xpath = "//td[contains(text(), 'lmond')]")
    private WebElement almondMoisturizer;

    @FindBy(xpath = "//td[contains(text(), 'loe')]//following-sibling::td")
    private WebElement aloeVeraMoisturizerPrice;

    @FindBy(xpath = "//td[contains(text(), 'lmond')]//following-sibling::td")
    private WebElement almondMoisturizerPrice;

    @FindBy(xpath = "//td[contains(text(), 'SPF-50')]")
    private WebElement SPF_50;

    @FindBy(xpath = "//td[contains(text(), 'SPF-50')]//following-sibling::td")
    private WebElement priceOfSPF_50;

    @FindBy(xpath = "//td[contains(text(), 'SPF-30')]")
    private WebElement SPF_30;

    @FindBy(xpath = "//td[contains(text(), 'SPF-30')]//following-sibling::td")
    private WebElement priceOfSPF_30;

    @FindBy(xpath = "//*[text() = 'Pay with Card']")
    private WebElement payWithCartButton;

    @FindBy(id = "card_number")
    private WebElement cardNumberFiled;

    @FindBy(id = "cc-exp")
    private WebElement expiryDateFiled;

    @FindBy(id="cc-csc")
    private WebElement cvvNumberFiled;

    @FindBy(id = "billing-zip")
    private WebElement zipCodeFiled;

    @FindBy(xpath = "//*[contains(text(), 'Pay')]")
    private WebElement payButton;

    @FindBy(xpath = "//input[@id = 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[contains(text(), 'PAYMENT')]")
    private WebElement paymentMessage;

    public void clickOnPayWithCartButton(){
        payWithCartButton.click();
    }

    public void fillStripeCredentials(){
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        emailField.sendKeys("abc@gmail.com");
        String cardNumber = "4242424242424242";
        Utilities.sendKeysWithNUMPAD(driver,Utilities.waitBeforeElementIsClickable(driver,cardNumberFiled),cardNumber);
        String exp_date = "1225";
        Utilities.sendKeysWithNUMPAD(driver, Utilities.waitBeforeElementIsClickable(driver,expiryDateFiled), exp_date);
        Utilities.waitBeforeElementIsClickable(driver,cvvNumberFiled).sendKeys("123");
        Utilities.waitBeforeElementIsClickable(driver,zipCodeFiled).sendKeys("421301");
        payButton.click();
        driver.switchTo().defaultContent();
    }

    public void assertPaymentSuccessfulMessageIsDisplayed(){
        Assert.assertTrue(paymentMessage.getText().contains("SUCCESS"), "Payment is successful");
    }

    public void assertThatSunscreenWithSPF_30IsPresentWithLeastExpensivePrice(int leastPriceWithSPF30){
        Assert.assertTrue(SPF_30.isDisplayed(), "Cart contains SPF_30 sunscreen");
        Assert.assertEquals(Utilities.extractInteger(priceOfSPF_30.getText()),leastPriceWithSPF30);
    }

    public void assertThatSunscreenWithSPF_50IsPresentWithLeastExpensivePrice(int leastPriceWithSPF50){
        Assert.assertTrue(SPF_50.isDisplayed(), "Cart contains SPF_50 sunscreen");
        Assert.assertEquals(Utilities.extractInteger(priceOfSPF_50.getText()), leastPriceWithSPF50);
    }

    public void assertThatAloeMoisturizerIsPresentWithLeastExpensivePrice(int leastPriceOfAloe){
        Assert.assertTrue(aloeVeraMoisturizer.getText().toLowerCase().contains("aloe"), "Cart contains aloe moisturizer");
        Assert.assertEquals(Utilities.extractInteger(aloeVeraMoisturizerPrice.getText()), leastPriceOfAloe);
    }

    public void assertThatAlmondMoisturizerIsPresentWithLeastExpensivePrice(int leastPriceOfAloe){
        Assert.assertTrue(almondMoisturizer.getText().toLowerCase().contains("almond"), "Cart contains almond moisturizer");
        Assert.assertEquals(Utilities.extractInteger(almondMoisturizerPrice.getText()), leastPriceOfAloe);
    }




}
