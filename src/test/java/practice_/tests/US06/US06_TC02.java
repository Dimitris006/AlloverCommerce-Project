package practice_.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_SearchPage;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class US06_TC02 {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_SearchPage alloverCommerceSearchPage;

    @Test
    public void TC02() {

        //create objects for pages
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_SearchPage alloverCommerceSearchPage = new AlloverCommerce_SearchPage();
        //navigate to URL
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

       //click on the search box
        alloverCommerceHomePage.searchBox.click();

        //enter the product name in the search box
        //String product name = "Iphone";
        alloverCommerceHomePage.searchBox.sendKeys("Hiphone");

        //click on the search button on the right side
        alloverCommerceHomePage.searchButton.click();

        // the page was changed

        JSUtils.scrollIntoViewJS(alloverCommerceSearchPage.modalName);
        WaitUtils.waitFor(3);

         // Click on the desired model on the search page
        alloverCommerceSearchPage.modalName.click();

        //Choose quantity to receive 2
        alloverCommerceSearchPage.plusQuantity_button.click();
        WaitUtils.waitFor(2);
        alloverCommerceSearchPage.ADDtoCART.click();
        Assert.assertTrue(alloverCommerceSearchPage.cartItem_quantity2.isDisplayed());

        //Complete Test
        Driver.closeDriver();
    }

}
