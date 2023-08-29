package practice_.tests.US08;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_Wishlist_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

import static org.testng.AssertJUnit.assertTrue;
import static practice_.utilities.JSUtils.clickWithTimeoutByJS;
import static practice_.utilities.JSUtils.scrollIntoViewJS;

public class US08_TC01 {

    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_Wishlist_Page alloverCommerceWishlistPage;

    @Test
    public void wishList01() {

        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Sign In Link
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceHomePage.signIn_Link.click();

        //Enter username or email address
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("customer_email"));

        //Enter password
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("customer_password"));

        //Click on Sign In Button
        alloverCommerceHomePage.signIn_Button.click();
        WaitUtils.waitFor(5);

        //Hoover over a product on slider, wishlist icon visible
        alloverCommerceWishlistPage = new AlloverCommerce_Wishlist_Page();
        scrollIntoViewJS(alloverCommerceWishlistPage.menClothingWishlist_Button);
        WaitUtils.waitFor(2);
        assertTrue(alloverCommerceWishlistPage.menClothingWishlist_Button.isDisplayed());

        //Click wishlist icon to add product to the wishlist
        WaitUtils.waitFor(2);
        clickWithTimeoutByJS(alloverCommerceWishlistPage.menClothingWishlist_Button);

        //Visibility of wishlist icon clicked
        WaitUtils.waitFor(2);
        assertTrue(alloverCommerceWishlistPage.menClothingWishlistButton_Clicked.isDisplayed());

        //Click on the wishlist icon again to see the wishlist
        WaitUtils.waitFor(2);
        clickWithTimeoutByJS(alloverCommerceWishlistPage.menClothingWishlist_Button);

        //The product added to the wishlist must be visible
        WaitUtils.waitFor(2);
        assertTrue(alloverCommerceWishlistPage.menClothing_Image.isDisplayed());

        //Click on Quick View button
        clickWithTimeoutByJS(alloverCommerceWishlistPage.wishlist_Page_Quick_View_Button);

        //View the properties of the products
        assertTrue(alloverCommerceWishlistPage.productsProperties.isDisplayed());

    }
    }