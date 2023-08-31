package practice_.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_SearchPage;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class US06_TC01 {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_SearchPage alloverCommerceSearchPage;

    @Test
    public void TC01() {

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Create objects for pages
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_SearchPage alloverCommerceSearchPage = new AlloverCommerce_SearchPage();

        //Click on the search box
        alloverCommerceHomePage.searchBox.click();

        //Enter the product name in the search field
        String productName = "Hiphone";
        alloverCommerceHomePage.searchBox.sendKeys(productName);

        //Click on the search button on the right side
        alloverCommerceHomePage.searchButton.click();

        // the page was changed +
        JSUtils.scrollIntoViewJS(alloverCommerceSearchPage.modalName);
        WaitUtils.waitFor(3);

        // Click on the desired model on the search page
        alloverCommerceSearchPage.modalName.click();

        //Verify a desired product is visible
        Assert.assertTrue(WaitUtils.waitForVisibility(alloverCommerceSearchPage.modalName, 15).isDisplayed()
        );

        //Complete test and close browser

        Driver.closeDriver();

        WaitUtils.waitFor(2);
      //  Driver.closeDriver();

    }
}