package practice_.tests.US17;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import practice_.pages.*;
import practice_.utilities.*;

public class US17_TC02 {
    @Test
    public void testcase02() {
        AlloverCommerce_HomePage alloverCommerceHomePage= new AlloverCommerce_HomePage();
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();
        AlloverCommerce_Orders_Page alloverCommerceOrdersPage = new AlloverCommerce_Orders_Page();
        AlloverCommerce_Wishlist_Page alloverCommerceWishlistPage = new AlloverCommerce_Wishlist_Page();
        AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage = new AlloverCommerce_Checkout_Page();

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Sign In button
        alloverCommerceHomePage.signIn_Link.click();
        WaitUtils.waitFor(2);

        //Enter Username or email address
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter Password
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on SIGN IN button
        alloverCommerceHomePage.signIn_Button.click();
        WaitUtils.waitFor(5);

        //Click on My Account
        JSUtils.clickWithTimeoutByJS(alloverCommerceHomePage.myAccountLink);

        //Click on Orders
        alloverCommerceMyAccountPage.ordersLink.click();

        //Click Browse Product
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(1,250);
        actions.perform();
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.goShopLink);

        //Select a product and click on Add To Cart button
        actions.scrollByAmount(1,250);
        actions.perform();
        alloverCommerceOrdersPage.macBookProLink.click();
        actions.scrollByAmount(1,250);
        actions.perform();
        JSUtils.clickWithTimeoutByJS(alloverCommerceOrdersPage.addToCartButton);

        //Click Cart button
        JSUtils.clickWithTimeoutByJS(alloverCommerceWishlistPage.wishlist_Page_Cart_Button);
        WaitUtils.waitFor(2);

        //Click Checkout button
        alloverCommerceWishlistPage.wishlist_Page_Checkout_Button.click();
        WaitUtils.waitFor(2);

        //Verify the product is seen
        BrowserUtils.verifyElementDisplayed(alloverCommerceCheckoutPage.verifyProductIsSeenAfterCheckoutButton);
        Driver.closeDriver();

    }
}
