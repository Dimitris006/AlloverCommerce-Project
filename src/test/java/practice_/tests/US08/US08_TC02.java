package practice_.tests.US08;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_Wishlist_Page;
import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

public class US08_TC02 {

    @Test
    public void testcase02() {
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

        //Click the wishlist button
        alloverCommerceWishlistPage.wishList_Button.click();

        //Click on QUICK VIEW button
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(1,250);
        actions.perform();
        alloverCommerceWishlistPage.wishlist_Page_Quick_View_Button.click();
        WaitUtils.waitFor(2);

        //Verify properties of the product is opened
        BrowserUtils.verifyElementDisplayed(alloverCommerceWishlistPage.wishlist_Page_Automatic_Crusher_Properties);
        Driver.closeDriver();
    }
}
