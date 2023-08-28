package practice_.tests.US18;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Coupons_Page;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.pages.AlloverCommerce_VendorRegistration_Page;
import practice_.utilities.*;


public class US18_TC07 {

    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_VendorRegistration_Page vendorRegistrationPage;
    AlloverCommerce_MyAccount_Page myAccountPage;
    AlloverCommerce_Coupons_Page couponsPage;

    @Test
    public void vendorSignIn(){

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Create objects for pages
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        vendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();
        myAccountPage = new AlloverCommerce_MyAccount_Page();
        couponsPage = new AlloverCommerce_Coupons_Page();

        //Click on Sign In Link
        alloverCommerceHomePage.signIn_Link.click();

        //Enter registered email into Username or email address field
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter valid password into Password field
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on Signin button
        alloverCommerceHomePage.signIn_Button.click();
        WaitUtils.waitFor(3);

        //Click on My Account link
        JSUtils.scrollIntoViewJS(vendorRegistrationPage.myAccountLink);
        WaitUtils.waitForClickablility(vendorRegistrationPage.myAccountLink, 2).click();

        //Click on Store Manager link
        myAccountPage.storeManagerLink.click();

        //Click on Coupons link
        JSUtils.clickWithTimeoutByJS(couponsPage.couponsLink);

        //Click on Add New button
        couponsPage.addCouponButton.click();

        //Verify Allow free shipping and Show on store is clickable
        WaitUtils.waitFor(3);
        JSUtils.clickWithTimeoutByJS(couponsPage.freeShippingCheckbox);
        BrowserUtils.verifyElementClickable(couponsPage.freeShippingCheckbox);
        JSUtils.clickWithTimeoutByJS(couponsPage.showOnStoreCheckbox);
        BrowserUtils.verifyElementClickable(couponsPage.showOnStoreCheckbox);

        //Complete test and close browser
        WaitUtils.waitFor(3);
        //ExtentReportUtils.flush();
        Driver.closeDriver();
    }
}
