package practice_.tests.US06;

import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Checkout_Page;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_SearchPage;
import practice_.utilities.*;

public class US06_TC04 {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_SearchPage alloverCommerceSearchPage;
    AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage;


    @Test
    public void practice() {

        //create objects for pages
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_SearchPage alloverCommerceSearchPage = new AlloverCommerce_SearchPage();
        AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage = new AlloverCommerce_Checkout_Page();
        //navigate to URL
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

       //click on the search box
        alloverCommerceHomePage.searchBox.click();

        //enter the product name in the search box
        //String product name = "Iphone";
        alloverCommerceHomePage.searchBox.sendKeys("Iphone");

        //click on the search button on the right side
        alloverCommerceHomePage.searchButton.click();

        // the page was changed

        JSUtils.scrollIntoViewJS(alloverCommerceSearchPage.modalName);
        WaitUtils.waitFor(3);

         // Click on the desired model on the search page
        alloverCommerceSearchPage.modalName.click();

        //Choose quantity to receive 2
        alloverCommerceSearchPage.QuantityPlus.click();
        WaitUtils.waitFor(1);
        alloverCommerceSearchPage.QuantityPlus.click();

        //Click on the ADD TO CART button
        alloverCommerceSearchPage.ADDtoCART.click();

       // Click on the CART icon
        alloverCommerceSearchPage.CARTicon.click();

        //Click on the VIEW_CART
        alloverCommerceSearchPage.VIEW_CART.click();

        BrowserUtils.verifyElementDisplayed(alloverCommerceSearchPage.hiPhone_productNameLink);

        // click on the QuantityMinus button
        alloverCommerceSearchPage.QuantityMinus.click();

        WaitUtils.waitFor(1);

        alloverCommerceSearchPage.QuantityMinus.click();

        //        Click on the UPDATE CART button
        alloverCommerceSearchPage.UPDATE_CART.click();

        BrowserUtils.verifyElementDisplayed(alloverCommerceSearchPage.quantityValue_1);

        //Complete Test

        //Driver.closeDriver();
    }

}
