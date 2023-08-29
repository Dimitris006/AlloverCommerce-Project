<<<<<<< HEAD
package practice_.tests.US08;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_Wishlist_Page;
import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

public class US08_TC01 {
    @Test
    public void testcase01() {
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_Wishlist_Page alloverCommerceWishlistPage = new AlloverCommerce_Wishlist_Page();
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

        //Click the Wishlist button
        alloverCommerceWishlistPage.wishList_Button.click();

        //Verify the product is added into the wishlist
        WaitUtils.waitFor(3);
        BrowserUtils.verifyElementDisplayed(alloverCommerceWishlistPage.verifyAddedProductToWishList);
        Driver.closeDriver();
    }
}