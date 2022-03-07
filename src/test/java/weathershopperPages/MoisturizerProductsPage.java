package weathershopperPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utilities;

import java.util.List;

public class MoisturizerProductsPage {
    private WebDriver driver;

    public MoisturizerProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Aloe')]//following-sibling::p")
    private List<WebElement> moisturizerListWithAloe;

    @FindBy(xpath = "//*[contains(text(), 'lmond')]//following-sibling::p")
    private List<WebElement> moisturizerWithAlmond;

    @FindBy(id = "cart")
    private WebElement cart;

    public int addToCartLeastExpensiveAloeMoisturizer(){
        int leastPriceOfAloe = Integer.MAX_VALUE;
        for (WebElement element : moisturizerListWithAloe) {
            if (Utilities.extractInteger(element.getText()) < leastPriceOfAloe) {
                leastPriceOfAloe = Utilities.extractInteger(element.getText());
            }
            System.out.println("Moisturizer price with aloe " + Utilities.extractInteger(element.getText()));
        }
        driver.findElement(By.xpath("//*[contains(text(), 'Aloe')]//following-sibling::p[contains(text(), '" + String.valueOf(leastPriceOfAloe)+ "')]//following-sibling::button")).click();
        return  leastPriceOfAloe;
    }

    public int addToCartLeastExpensiveAlmondMoisturizer(){
        int leastPriceOfAlmond = Integer.MAX_VALUE;
        for (WebElement element : moisturizerWithAlmond) {
            if (Utilities.extractInteger(element.getText()) < leastPriceOfAlmond) {
                leastPriceOfAlmond = Utilities.extractInteger(element.getText());
            }
            System.out.println("Moisturizer price with almonds" + Utilities.extractInteger(element.getText()));
        }

        driver.findElement(By.xpath("//*[contains(text(), 'lmond')]//following-sibling::p[contains(text(), '" + String.valueOf(leastPriceOfAlmond) + "')]//following-sibling::button")).click();
        return leastPriceOfAlmond;
    }

    public void clickOnCart(){
        cart.click();
    }



}
