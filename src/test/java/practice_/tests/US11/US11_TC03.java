package practice_.tests.US11;

import com.google.common.base.Verify;
import org.testng.annotations.Test;
import practice_.pages.*;
import practice_.utilities.*;

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
        AlloverCommerce_SupportTicket_Page alloverCommerceSupportTicketPage;
        AlloverCommerce_Followings_Page alloverCommerceFollowingsPage;

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
        alloverCommerceSupportTicketPage = new AlloverCommerce_SupportTicket_Page();
        alloverCommerceFollowingsPage = new AlloverCommerce_Followings_Page();

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
        JSUtils.scrollIntoViewJS(alloverCommerceHomePage.myAccountLink);
        JSUtils.clickWithTimeoutByJS(alloverCommerceHomePage.myAccountLink);

        //Verify Orders is visible
        assertTrue(alloverCommerceMyAccountPage.ordersLink.isDisplayed());
        //Verify Orders is clickable
        alloverCommerceMyAccountPage.ordersLink.click();
        WaitUtils.waitFor(2);
        assertTrue(alloverCommerceOrdersPage.ordersHeader.isDisplayed());

        //Verify Downloads is visible
        assertTrue(alloverCommerceMyAccountPage.downloadsLink.isDisplayed());
        //Verify Downloads is clickable
        alloverCommerceMyAccountPage.downloadsLink.click();
        WaitUtils.waitFor(2);
        assertTrue(alloverCommerceDownloadsPage.downloadsHeader.isDisplayed());

        //Verify Addresses is visible
        assertTrue(alloverCommerceMyAccountPage.addressesLink.isDisplayed());
        //Verify Addresses is clickable
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.addressesLink);
        assertTrue(alloverCommerceAddressesPage.addressesHeader.isDisplayed());

        //Verify Account Details is visible
        assertTrue(alloverCommerceMyAccountPage.accountDetailslink.isDisplayed());
        //Verify Account details is clickable
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.accountDetailslink);
        assertTrue(Driver.getDriver().getCurrentUrl().contains("account"));

        //Verify Wishlist is visible
        assertTrue(alloverCommerceMyAccountPage.wishlistLink.isDisplayed());
        //Verify Wishlist is clickable
        JSUtils.scrollIntoViewJS(alloverCommerceMyAccountPage.wishlistLink);
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.wishlistLink);
        assertTrue(alloverCommerceWishlistPage.wishlistHeaderSmall.isDisplayed());

        //Click on My Account link
        JSUtils.scrollIntoViewJS(alloverCommerceHomePage.myAccountLink);
        JSUtils.clickWithTimeoutByJS(alloverCommerceHomePage.myAccountLink);

        //Verify Support Tickets is visible
        assertTrue(alloverCommerceMyAccountPage.supportTicketsLink.isDisplayed());
        //Verify Support Tickets is clickable
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.supportTicketsLink);
        assertTrue(alloverCommerceSupportTicketPage.supportTicketText.isDisplayed());

        //Verify Followings is visible
        assertTrue(alloverCommerceMyAccountPage.followingsLink.isDisplayed());
        //Verify Followings is clickable
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.followingsLink);
        assertTrue(alloverCommerceFollowingsPage.followingsText.isDisplayed());

        //Verify Logout is visible
        assertTrue(alloverCommerceMyAccountPage.logoutLink.isDisplayed());
        //Verify Logout is clickable
        JSUtils.clickWithTimeoutByJS(alloverCommerceMyAccountPage.logoutLink);
        assertTrue(alloverCommerceHomePage.register_Link.isDisplayed());

        //Complete test and close browser
        WaitUtils.waitFor(2);
        Driver.closeDriver();
    }
}
