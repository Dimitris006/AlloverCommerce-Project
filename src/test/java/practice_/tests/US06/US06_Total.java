package practice_.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Checkout_Page;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_SearchPage;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

import static org.testng.AssertJUnit.assertTrue;

public class US06_Total {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_SearchPage alloverCommerceSearchPage;
    AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage;


    @Test
    public void practice() {

        //create objects for pages
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_SearchPage alloverCommerceSearchPage = new AlloverCommerce_SearchPage();
        //AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage = new AlloverCommerce_Checkout_Page();
        AlloverCommerce_Checkout_Page alloverCommerceCheckoutPage = new AlloverCommerce_Checkout_Page();
        //navigate to URL
        Driver.getDriver().get("https://allovercommerce.com/");

       //click on the search box
        alloverCommerceHomePage.searchBox.click();

        // wait until the WebElement is visible
        //The wait will be for 15s
        Assert.assertTrue(WaitUtils.waitForVisibility(alloverCommerceHomePage.searchBox, 15).isDisplayed()
        );

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

        //Click on the ADD TO CART button
        alloverCommerceSearchPage.ADDtoCART.click();

       // Click on the CART icon
        alloverCommerceSearchPage.CARTicon.click();

        //Click on  the CHECKOUT button
        alloverCommerceSearchPage.CHECKOUT.click();

     //Click on the CART icon
        alloverCommerceSearchPage.CARTicon.click();

        //Click on the VIEW_CART
        alloverCommerceSearchPage.VIEW_CART.click();

       // click on the QuantityMinus button
        alloverCommerceSearchPage.QuantityMinus.click();

        JSUtils.scrollIntoViewJS(alloverCommerceSearchPage.modalName);
        WaitUtils.waitFor(3);

        alloverCommerceSearchPage.QuantityMinus.click();
       // alloverCommerceSearchPage.QuantityMinus.click();

//        Click on the UPDATE CART button
        alloverCommerceSearchPage.UPDATE_CART.click();

        //User should be able to see the billing address in order to purchase the products

        WaitUtils.waitFor(5);

       alloverCommerceSearchPage.PROCEED_TO_CHECKOUT_button.click();

//        User should be able to see and choose payment options

       JSUtils.scrollIntoViewJS(alloverCommerceCheckoutPage.Pay_at_the_door);
        WaitUtils.waitFor(5);


       alloverCommerceCheckoutPage.Pay_at_the_door.click();;
        Assert.assertTrue(WaitUtils.waitForVisibility(alloverCommerceCheckoutPage.Pay_at_the_door, 15).isDisplayed());
        WaitUtils.waitFor(5);
        alloverCommerceCheckoutPage.Wire_transfer_EFT.click();

        // User should be able to complete shopping process
        //Click on the PLACE ORDER button

        JSUtils.scrollIntoViewJS(alloverCommerceCheckoutPage.checkout_Place_Order_Button);
        WaitUtils.waitFor(5);
          // the page was changed
        alloverCommerceCheckoutPage.checkout_Place_Order_Button.click();
       // alloverCommerceCheckoutPage2.Wire_transfer_EFT.click();


        //Complete Test

        Driver.closeDriver();
    }

}
