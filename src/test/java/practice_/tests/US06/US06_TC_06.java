package practice_.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Checkout_Page;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_SearchPage;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class US06_TC_06 {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_SearchPage alloverCommerceSearchPage;
    AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage;
    @Test
    public void SeeBillingAddress() {

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Create objects for pages
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_SearchPage alloverCommerceSearchPage = new AlloverCommerce_SearchPage();
        AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage = new AlloverCommerce_Checkout_Page();
        //Click on the search box
        alloverCommerceHomePage.searchBox.click();

        // Wait until the WebElement is visible
        //The wait will be 15s
        Assert.assertTrue(WaitUtils.waitForVisibility(alloverCommerceHomePage.searchBox, 15).isDisplayed());

        //Enter the product name in the search field
        String productName = "Iphone";
        alloverCommerceHomePage.searchBox.sendKeys(productName);

        //Click on the search button on the right side
        alloverCommerceHomePage.searchButton.click();

        // the page was changed +
        JSUtils.scrollIntoViewJS(alloverCommerceSearchPage.modalName);
        WaitUtils.waitFor(5);

        // Click on the desired model on the search page
        alloverCommerceSearchPage.modalName.click();

        //Click on the ADD TO CART button
        alloverCommerceSearchPage.ADDtoCART.click();

        // Click on the CART icon
        alloverCommerceSearchPage.CARTicon.click();

        //Click on the VIEW_CART
        alloverCommerceSearchPage.CHECKOUT.click();

        //Verify the   billing address is visible
        Assert.assertTrue(WaitUtils.waitForVisibility(alloverCommerceCheckoutPage.checkout_Place_Order_Button, 15).isDisplayed());

        //User should be able to see and choose payment options

        JSUtils.scrollIntoViewJS(alloverCommerceCheckoutPage.Pay_at_the_door);
        WaitUtils.waitFor(5);

        alloverCommerceCheckoutPage.Pay_at_the_door.click();;
        Assert.assertTrue(WaitUtils.waitForVisibility(alloverCommerceCheckoutPage.Pay_at_the_door, 15).isDisplayed());
        WaitUtils.waitFor(5);

        alloverCommerceCheckoutPage.Wire_transfer_EFT.click();

        //Complete test and close browser
        WaitUtils.waitFor(2);
        Driver.closeDriver();
    }
}