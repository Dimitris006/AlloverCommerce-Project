package practice_.tests.US20;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import practice_.pages.*;
import practice_.utilities.*;

import java.io.IOException;

import static org.testng.Assert.assertFalse;

public class US20_TC01 {


    @Test
    public void testcase01() throws IOException {
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

        //Enter registered email into Username or email address field
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter valid password into Password field
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on SIGN IN button
        alloverCommerceHomePage.signIn_Button.click();
        WaitUtils.waitFor(5);

        //Click on My Account
        JSUtils.clickWithTimeoutByJS(alloverCommerceHomePage.myAccountLink);

        //Click on Orders
        alloverCommerceMyAccountPage.ordersLink.click();

        //Click Go shop button
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

        //Click enter your code link
        alloverCommerceCheckoutPage.enterYourCodeLink.click();

        //Enter coupon code
        alloverCommerceCheckoutPage.enterCouponCode.sendKeys(ConfigReader.getProperty("coupon_code"));

        //Click on Apply coupon button
        alloverCommerceCheckoutPage.applyCoupon.click();
        WaitUtils.waitFor(2);

        //Verify if coupon code is applied
        BrowserUtils.verifyElementDisplayed(alloverCommerceCheckoutPage.couponNotApplicableMessage);
        MediaUtils.takeScreenshotOfThisElement(alloverCommerceCheckoutPage.couponNotApplicableMessage);

        //Complete test and close browser
        WaitUtils.waitFor(3);
        Driver.closeDriver();

    }
}