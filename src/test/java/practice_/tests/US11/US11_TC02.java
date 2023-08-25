package practice_.tests.US11;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.MyAccount_Page;
import practice_.pages.VendorRegistration_Page;
import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

import static org.testng.AssertJUnit.assertTrue;

public class US11_TC02 {

    @Test
    public void elementsVisibilityOnMyAccount(){
        AlloverCommerce_HomePage alloverCommerceHomePage;
        VendorRegistration_Page vendorRegistrationPage;
        MyAccount_Page myAccountPage;

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Create allover commerce, vendor registration and my account objects
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        vendorRegistrationPage = new VendorRegistration_Page();
        myAccountPage = new MyAccount_Page();

        //Click on Sign In Link
        alloverCommerceHomePage.signIn_Link.click();

        //Enter registered email into Username or email address field
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter valid password into Password field
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on Signin button
        alloverCommerceHomePage.signIn_Button.click();
        WaitUtils.waitFor(3);

        //Verify My Account is displayed
        assertTrue(vendorRegistrationPage.myAccountLink.isDisplayed());

        //Click on My Account link
//        BrowserUtils.switchIframeByWebElement(myAccountPage.myAccount.getText());
//        vendorRegistrationPage.myAccountLink1.click();

        //Verify Dashboard is visible
        assertTrue(myAccountPage.dashboardLink.isDisplayed());

        //Verify Store Manager is visible
        assertTrue(myAccountPage.storeManagerLink.isDisplayed());

        //Verify Orders is visible
        assertTrue(myAccountPage.ordersLink.isDisplayed());

        //Verify Downloads is visible
        assertTrue(myAccountPage.downloadsLink.isDisplayed());

        //Verify Addresses is visible
        assertTrue(myAccountPage.addressesLink.isDisplayed());

        //Verify Account details is visible
        assertTrue(myAccountPage.accountDetailslink.isDisplayed());

        //Verify Wishlist is visible
        assertTrue(myAccountPage.wishlistLinks.isDisplayed());

        //Verify Support Tickets is visible
        assertTrue(myAccountPage.supportTicketsLink.isDisplayed());

        //Verify Followings is visible
        assertTrue(myAccountPage.followingsLink.isDisplayed());

        //Verify Logout is visible
        assertTrue(myAccountPage.logoutLink.isDisplayed());

        //Complete test and close browser
        WaitUtils.waitFor(2);
        Driver.closeDriver();
    }
}
