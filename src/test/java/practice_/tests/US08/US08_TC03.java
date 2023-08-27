package practice_.tests.US08;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import practice_.pages.*;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

public class US08_TC03 {
    @Test
    public void testcase03() {
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_Wishlist_Page alloverCommerceWishlistPage = new AlloverCommerce_Wishlist_Page();
        AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage = new AlloverCommerce_Checkout_Page();
        AlloverCommerce_Orders_Page alloverCommerceOrdersPage = new AlloverCommerce_Orders_Page();
        Actions actions = new Actions(Driver.getDriver());

        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Search box write product name in Search box
        //Click the search button
        WaitUtils.waitFor(2);
        alloverCommerceHomePage.searchBox.click();
        alloverCommerceHomePage.searchBox.sendKeys("Automatic Crusher", Keys.ENTER);

        //Click on wishlist icon
        alloverCommerceWishlistPage.homepage_Add_Wishlist_Button.click();
        WaitUtils.waitFor(3);

        //Click the wishlist button
        alloverCommerceWishlistPage.wishList_Button.click();
        WaitUtils.waitFor(2);

        //Click on ADD TO CART button
        actions.scrollByAmount(1,250);
        actions.perform();
        alloverCommerceWishlistPage.wishlist_Page_Add_To_Cart.click();
        WaitUtils.waitFor(2);

        //Click on "Cart" button
        alloverCommerceWishlistPage.wishlist_Page_Cart_Button.click();

        //Click on Checkout button
        alloverCommerceWishlistPage.wishlist_Page_Checkout_Button.click();

        //Enter first name in first name area
        alloverCommerceCheckoutPage.checkout_Firstname.sendKeys("Jane");

        //Enter last name in last name area
        alloverCommerceCheckoutPage.checkout_Lastname.sendKeys("Doe");

        //Select the Country from Country/Region DDM
        actions.scrollByAmount(1,250);
        actions.perform();
        Select select = new Select(alloverCommerceCheckoutPage.checkout_Country);
        select.selectByValue("US");
        WaitUtils.waitFor(1);

        //Enter your Street Address in Street address area
        alloverCommerceCheckoutPage.checkout_Street.sendKeys("Flower Street");

        //Enter your Town/City in Town/City area
        actions.scrollByAmount(1,250);
        actions.perform();
        WaitUtils.waitFor(1);
        alloverCommerceCheckoutPage.checkout_City.sendKeys("New York City");

        //Select your State from State DDM
        Select select1 = new Select(alloverCommerceCheckoutPage.checkout_State);
        select1.selectByValue("NY");
        WaitUtils.waitFor(2);

        //Enter your postcode in Postcode/Zip area
        alloverCommerceCheckoutPage.checkout_ZIP.sendKeys("12345");

        //Enter your phone number in Phone area
        alloverCommerceCheckoutPage.checkout_Phone.sendKeys("1234567890");

        //Enter your Email address in Email address area
        actions.scrollByAmount(1,250);
        actions.perform();
        alloverCommerceCheckoutPage.checkout_email.sendKeys("abc123@gmail.com");
        WaitUtils.waitFor(4);

        //Click on Place Order button
        alloverCommerceCheckoutPage.checkout_Place_Order_Button.click();

        //Verify the message "Thank you. Your order has been received." is seen
        alloverCommerceOrdersPage.verifyOrderMessageIsSeen.isDisplayed();

    }
}
