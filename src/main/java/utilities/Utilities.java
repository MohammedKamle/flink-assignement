package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    public static int extractInteger(String str) {
        Matcher matcher = Pattern.compile("\\d+").matcher(str);

        if (!matcher.find())
            throw new NumberFormatException("For input string [" + str + "]");

        return Integer.parseInt(matcher.group());
    }

    public static void sendKeysWithNUMPAD(WebDriver driver, WebElement element, String cardNumber){
        for (char c : cardNumber.toCharArray()){
            switch (Integer.parseInt(String.valueOf(c))){
                case 1:
                    element.sendKeys(Keys.NUMPAD1);
                    break;
                case 2:
                    element.sendKeys(Keys.NUMPAD2);
                    break;
                case 3:
                    element.sendKeys(Keys.NUMPAD3);
                    break;
                case 4:
                    element.sendKeys(Keys.NUMPAD4);
                    break;
                case 5:
                    element.sendKeys(Keys.NUMPAD5);
                    break;
                case 6:
                    element.sendKeys(Keys.NUMPAD6);
                    break;
                case 7:
                    element.sendKeys(Keys.NUMPAD7);
                    break;
                case 8:
                    element.sendKeys(Keys.NUMPAD8);
                    break;
                case 9:
                    element.sendKeys(Keys.NUMPAD9);
                    break;
                case 0:
                    element.sendKeys(Keys.NUMPAD0);
                    break;
            }
        }
    }

    public static WebElement waitBeforeElementIsClickable(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitBeforeElementIsVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


}
