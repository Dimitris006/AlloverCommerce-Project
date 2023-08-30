package practice_.tests.US19;

import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.WaitUtils;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Checkout_Page;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_SearchPage;
import practice_.utilities.*;

public class US19_TC01 {
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_SearchPage alloverCommerceSearchPage;
        AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage;

        @Test
        public void TC01() {

                //create objects for pages
                AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
                AlloverCommerce_SearchPage alloverCommerceSearchPage = new AlloverCommerce_SearchPage();
                AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage = new AlloverCommerce_Checkout_Page();
                //navigate to URL
                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

                //Customer sign-in
                alloverCommerceHomePage.signIn_Link.click();
                alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("customer_email"));
                alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("customer_password"));
                alloverCommerceHomePage.signIn_Button.click();
                WaitUtils.waitFor(2);

                //click on the search box
                alloverCommerceHomePage.searchBox.click();

                //enter the product name in the search box
                //String product name = "Iphone";
                alloverCommerceHomePage.searchBox.sendKeys("Iphone");

                //click on the search button on the right side
                alloverCommerceHomePage.searchButton.click();

                JSUtils.scrollIntoViewJS(alloverCommerceSearchPage.hiPhone_productNameLink);
                WaitUtils.waitFor(3);

                // Click on the desired model on the search page
                alloverCommerceSearchPage.hiPhone_productNameLink.click();

                //Click on the ADD TO CART button
                alloverCommerceSearchPage.ADDtoCART.click();

                // Click on the CART icon
                alloverCommerceSearchPage.CARTicon.click();

                //Click on  the CHECKOUT button
                alloverCommerceSearchPage.CHECKOUT.click();

                alloverCommerceCheckoutPage.enterYourCodeLink.click();

                //Enter coupon code
                alloverCommerceCheckoutPage.enterCouponCode.sendKeys(ConfigReader.getProperty("coupon_code"));

                //Click on Apply coupon button
                alloverCommerceCheckoutPage.applyCoupon.click();
                WaitUtils.waitFor(2);

                //Verify if coupon code is applied
                BrowserUtils.verifyElementNotDisplayed(alloverCommerceCheckoutPage.couponNotApplicableMessage);

                //User should be able to see and choose payment options

                alloverCommerceCheckoutPage.placeOrder_Button.click();

                //Complete Test
                Driver.closeDriver();
        }

}

