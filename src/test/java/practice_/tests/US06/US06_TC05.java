package practice_.tests.US06;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Checkout_Page;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_SearchPage;
import practice_.utilities.*;

public class US06_TC05 {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_SearchPage alloverCommerceSearchPage;
    AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage;

    @Test
    public void TC05() {

        //create objects for pages
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_SearchPage alloverCommerceSearchPage = new AlloverCommerce_SearchPage();
        AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage = new AlloverCommerce_Checkout_Page();
        //navigate to URL
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

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

        BrowserUtils.verifyElementDisplayed(alloverCommerceCheckoutPage.billingAddress_field);

        //Complete Test

        Driver.closeDriver();
    }

}
