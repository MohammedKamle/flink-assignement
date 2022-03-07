package weathershopperPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utilities;

import java.util.List;

public class SunscreenProductLandingPage {
    private WebDriver driver;

    public SunscreenProductLandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'SPF-50')]//following-sibling::p")
    private List<WebElement> sunscreenListWithSPF_50;

    @FindBy(xpath = "//*[contains(text(), 'SPF-30')]//following-sibling::p")
    private List<WebElement> sunscreenListWithSPF_30;

    @FindBy(id = "cart")
    private WebElement cart;

    public int addToCartLeastExpensiveSunscreenWithSPF_50(){
        int leastPriceWithSPF50 = Integer.MAX_VALUE;
        for (WebElement element : sunscreenListWithSPF_50) {
            if (Utilities.extractInteger(element.getText()) < leastPriceWithSPF50) {
                leastPriceWithSPF50 = Utilities.extractInteger(element.getText());
            }
            // System.out.println("Sunscreen price "+element.getText().replaceAll("[^0-9]]", ""));
            System.out.println("Sunscreen price with SPF-50" + Utilities.extractInteger(element.getText()));
        }
        driver.findElement(By.xpath("//*[contains(text(), 'SPF-50')]//following-sibling::p[contains(text(), '" + String.valueOf(leastPriceWithSPF50) + "')]//following-sibling::button")).click();
        return  leastPriceWithSPF50;
    }

    public int addToCartLeastExpensiveSunscreenWithSPF_30(){
        int leastPriceWithSPF30 = Integer.MAX_VALUE;
        for (WebElement element : sunscreenListWithSPF_30) {
            if (Utilities.extractInteger(element.getText()) < leastPriceWithSPF30) {
                leastPriceWithSPF30 = Utilities.extractInteger(element.getText());
            }
            // System.out.println("Sunscreen price "+element.getText().replaceAll("[^0-9]]", ""));
            System.out.println("Sunscreen price with SPF_30 " + Utilities.extractInteger(element.getText()));
        }
        driver.findElement(By.xpath("//*[contains(text(), 'SPF-30')]//following-sibling::p[contains(text(), '" + String.valueOf(leastPriceWithSPF30) + "')]//following-sibling::button")).click();
        return leastPriceWithSPF30;
    }

    public void clickOnCart(){
        cart.click();
    }


}
