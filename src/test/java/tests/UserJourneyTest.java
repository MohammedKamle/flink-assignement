package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import weathershopperPages.CartPage;
import weathershopperPages.LandingPage;
import weathershopperPages.MoisturizerProductsPage;
import weathershopperPages.SunscreenProductLandingPage;
import utilities.BaseClass;

public class UserJourneyTest extends BaseClass {
    private LandingPage landingPage;
    private MoisturizerProductsPage moisturizerProductsPage;
    private SunscreenProductLandingPage sunscreenProductLandingPage;
    private CartPage cartPage;

    @BeforeClass
    public void beforeClass() {
        landingPage = new LandingPage(getDriver());
        moisturizerProductsPage = new MoisturizerProductsPage(getDriver());
        sunscreenProductLandingPage = new SunscreenProductLandingPage(getDriver());
        cartPage = new CartPage(getDriver());
    }

    @Test
    public void testEndToEndUserJourney() {
        int temperature = landingPage.getTheTemperature();
        // If temperature is less than 19 we will buy moisturizer else we will buy Sunscreen
        if (temperature < 19) {
            landingPage.clickOnBuyMoisturizer();
            int leastExpensivePriceOfAloe = moisturizerProductsPage.addToCartLeastExpensiveAloeMoisturizer();
            int leastExpensivePriceOfAlmond = moisturizerProductsPage.addToCartLeastExpensiveAlmondMoisturizer();
            moisturizerProductsPage.clickOnCart();
            // Assertion
            cartPage.assertThatAlmondMoisturizerIsPresentWithLeastExpensivePrice(leastExpensivePriceOfAlmond);
            cartPage.assertThatAloeMoisturizerIsPresentWithLeastExpensivePrice(leastExpensivePriceOfAloe);
        } else {
            landingPage.clickOnBuySunscreen();
            int leastExpensivePriceWithSPF_50 = sunscreenProductLandingPage.addToCartLeastExpensiveSunscreenWithSPF_50();
            int leastExpensivePriceWithSPF_30 = sunscreenProductLandingPage.addToCartLeastExpensiveSunscreenWithSPF_30();
            sunscreenProductLandingPage.clickOnCart();
            //Assertion
            cartPage.assertThatSunscreenWithSPF_50IsPresentWithLeastExpensivePrice(leastExpensivePriceWithSPF_50);
            cartPage.assertThatSunscreenWithSPF_30IsPresentWithLeastExpensivePrice(leastExpensivePriceWithSPF_30);
        }
        cartPage.clickOnPayWithCartButton();
        cartPage.fillStripeCredentials();
        //Assertion
        cartPage.assertPaymentSuccessfulMessageIsDisplayed();
    }

}
