package practice_.tests.US11;

import org.testng.annotations.Test;
import practice_.pages.*;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

import static org.testng.AssertJUnit.assertTrue;

public class US11_TC03 {

    @Test
    public void elementsVisibilityOnMyAccount(){
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage;
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;
        AlloverCommerce_StoreManager_Page alloverCommerceStoreManagerPage;
        AlloverCommerce_Orders_Page alloverCommerceOrdersPage;
        AlloverCommerce_Downloads_Page alloverCommerceDownloadsPage;
        AlloverCommerce_AddressesPage alloverCommerceAddressesPage;
        AlloverCommerce_AccountDetails_Page alloverCommerceAccountDetailsPage;
        AlloverCommerce_Wishlist_Page alloverCommerceWishlistPage;

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Create objects for each page
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();
        alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();
        alloverCommerceStoreManagerPage = new AlloverCommerce_StoreManager_Page();
        alloverCommerceOrdersPage = new AlloverCommerce_Orders_Page();
        alloverCommerceDownloadsPage = new AlloverCommerce_Downloads_Page();
        alloverCommerceAddressesPage = new AlloverCommerce_AddressesPage();
        alloverCommerceAccountDetailsPage = new AlloverCommerce_AccountDetails_Page();
        alloverCommerceWishlistPage = new AlloverCommerce_Wishlist_Page();

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
        assertTrue(alloverCommerceVendorRegistrationPage.myAccountLink.isDisplayed());

        //Click on My Account link
        JSUtils.scrollIntoViewJS(alloverCommerceVendorRegistrationPage.myAccountLink);
        WaitUtils.waitForClickablility(alloverCommerceVendorRegistrationPage.myAccountLink, 2).click();

        //Verify Dashboard is visible
        assertTrue(alloverCommerceMyAccountPage.dashboardLink.isDisplayed());
        //Verify Dashboard is clickable
        alloverCommerceMyAccountPage.dashboardLink.click();
        assertTrue(alloverCommerceMyAccountPage.dashboardLink.isDisplayed());

        //Verify Store Manager is visible
        assertTrue(alloverCommerceMyAccountPage.storeManagerLink.isDisplayed());
        //Verify Store Manager is clickable
        alloverCommerceMyAccountPage.storeManagerLink.click();
        assertTrue(alloverCommerceStoreManagerPage.storeManagerHeader.isDisplayed());

        //Click on My Account link
        JSUtils.scrollIntoViewJS(alloverCommerceVendorRegistrationPage.myAccountLink);
        WaitUtils.waitForClickablility(alloverCommerceVendorRegistrationPage.myAccountLink, 2).click();

        //Verify Orders is visible
        assertTrue(alloverCommerceMyAccountPage.ordersLink.isDisplayed());
        //Verify Orders is clickable
        alloverCommerceMyAccountPage.ordersLink.click();
        assertTrue(alloverCommerceOrdersPage.ordersHeader.isDisplayed());

        //Verify Downloads is visible
        assertTrue(alloverCommerceMyAccountPage.downloadsLink.isDisplayed());
        //Verify Downloads is clickable
        alloverCommerceMyAccountPage.downloadsLink.click();
        assertTrue(alloverCommerceDownloadsPage.downloadsHeader.isDisplayed());

        //Verify Addresses is visible
        assertTrue(alloverCommerceMyAccountPage.addressesLink.isDisplayed());
        //Verify Addresses is clickable
        alloverCommerceMyAccountPage.addressesLink.click();
        assertTrue(alloverCommerceAddressesPage.addressesHeader.isDisplayed());

        //Verify Account details is visible
        assertTrue(alloverCommerceMyAccountPage.accountDetailslink.isDisplayed());
        //Verify Account details is clickable
        alloverCommerceMyAccountPage.accountDetailslink.click();
        assertTrue(alloverCommerceAccountDetailsPage.accountDetailsHeader.isDisplayed());

        //Verify Wishlist is visible
        assertTrue(alloverCommerceMyAccountPage.wishlistLinks.isDisplayed());
        //Verify Wishlist is clickable
        alloverCommerceMyAccountPage.wishlistLinks.click();
        assertTrue(alloverCommerceWishlistPage.wishlistHeader.isDisplayed());




        //Verify Support Tickets is visible
        assertTrue(alloverCommerceMyAccountPage.supportTicketsLink.isDisplayed());
        //Verify Support Tickets is clickable
        alloverCommerceMyAccountPage.supportTicketsLink.click();
        assertTrue(alloverCommerceMyAccountPage.supportTicketsLink.isDisplayed());




        //Verify Followings is visible
        assertTrue(alloverCommerceMyAccountPage.followingsLink.isDisplayed());
        //Verify Followings is clickable
        alloverCommerceMyAccountPage.followingsLink.click();




        //Verify Logout is visible
        assertTrue(alloverCommerceMyAccountPage.logoutLink.isDisplayed());
        //Verify Logout is clickable
        alloverCommerceMyAccountPage.logoutLink.click();
        assertTrue(alloverCommerceHomePage.register_Link.isDisplayed());

        //Complete test and close browser
        WaitUtils.waitFor(2);
        Driver.closeDriver();
    }
}
