package practice_.tests.US06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_SearchPage;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class US06_TC01 {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_SearchPage alloverCommerceSearchPage;
   // AlloverCommerce_Checkout_Page alloverCommerce_checkout_page;

    @Test
    public void practice() {

        //create object for pages
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        AlloverCommerce_SearchPage alloverCommerceSearchPage = new AlloverCommerce_SearchPage();

        //navigate to URL
        Driver.getDriver().get("https://allovercommerce.com/");

       //click on the search box
        alloverCommerceHomePage.searchBox.click();

        // wait until the WebElement is visible
        //The wait will be for 15s
        Assert.assertTrue(WaitUtils.waitForVisibility(alloverCommerceHomePage.searchBox, 15).isDisplayed()
        );

        //enter the product name in the search box
//        String product name = "Iphone";
        alloverCommerceHomePage.searchBox.sendKeys("Iphone");

        //click on the search button on the right side

        alloverCommerceHomePage.searchButton.click();
        // the page was changed
         //AlloverCommerce_SearchPage alloverCommerceSearchPage = new AlloverCommerce_SearchPage();

        JSUtils.scrollIntoViewJS(alloverCommerceSearchPage.lovely_Iphone);
        WaitUtils.waitFor(3);

         // Click on the desired model on the search page
        alloverCommerceSearchPage.lovely_Iphone.click();

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

        JSUtils.scrollIntoViewJS(alloverCommerceSearchPage.lovely_Iphone);
        WaitUtils.waitFor(3);

        alloverCommerceSearchPage.QuantityMinus.click();
       // alloverCommerceSearchPage.QuantityMinus.click();

//        Click on the UPDATE CART button
        alloverCommerceSearchPage.UPDATE_CART.click();

        //User should be able to see the billing address in order to purchase the products

        JSUtils.scrollIntoViewJS(alloverCommerceSearchPage.lovely_Iphone);
        WaitUtils.waitFor(3);

        alloverCommerceSearchPage.PROCEED_TO_CHECKOUT_button.click();
//
//        User should be able to see and choose payment options

//        //password
//        alloverCommerceHomePage.signUp_Password.sendKeys(password);
//
//        //checkbox
//        alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
//
//        //sign up
//        alloverCommerceHomePage.signUp_Button.click();
//
//        //check sign out shows
//        WebElement signOut = Driver.getDriver().findElement(By.cssSelector("a[href=\"https://allovercommerce.com/my-account-2/customer-logout/\"]"));
//
//        //check if sign out link is there
//        Assert.assertTrue(
//                WaitUtils.waitForVisibility(signOut, 15).isDisplayed()
//        );
//
//        //sign out account here
//        signOut.click();
//
//        //locate sign out link again on page
//        WebElement signOutLink = Driver.getDriver().findElement(By.xpath("//a[.='Log out']"));
//
//        //sign out confirmation done here
//        signOutLink.click();
//
//        //use wait. Check if sign in button is showing
//        Assert.assertTrue(
//                WaitUtils.waitForVisibility(alloverCommerceHomePage.signIn_Link, 15).isDisplayed()
//        );
//
//        //click sign in link
//        alloverCommerceHomePage.signIn_Link.click();
//
//        //verify that pop up is showing by locating sign in
//        Assert.assertTrue(
//                WaitUtils.waitForVisibility(alloverCommerceHomePage.signIn_Button, 15).isDisplayed()
//        );
//
//        //fill in username
//        alloverCommerceHomePage.signIn_Username.sendKeys(username);
//
//        //fill in password
//        alloverCommerceHomePage.signIn_Password.sendKeys(password);
//
//        //click signIn button
//        alloverCommerceHomePage.signIn_Button.click();
//
//        //wait for sign in + verify that 'My Account' isDisplayed
//        WebElement myAccountText = Driver.getDriver().findElement(By.xpath("//h2[.='My Account']"));
//        Assert.assertTrue(
//                WaitUtils.waitForVisibility(myAccountText, 15).isDisplayed()
//        );
//
//        //Complete Test
//
//        Driver.closeDriver();
    }

}
