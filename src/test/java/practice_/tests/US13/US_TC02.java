package practice_.tests.US13;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import practice_.pages.*;


import practice_.utilities.*;

import static org.testng.AssertJUnit.assertTrue;
import static practice_.utilities.JSUtils.clickWithTimeoutByJS;

public class US_TC02 {
    AlloverCommerce_MyAccountCustomerPage myAccountCustomerPage;

    @Test
    public void elementsVisibilityOnMyAccount() {

        Faker faker = new Faker();
        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Sign In Link
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceHomePage.signIn_Link.click();

        //Enter username or email address
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter password
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on Sign In Button
        alloverCommerceHomePage.signIn_Button.click();

        //Click on Sign Out Link
        WaitUtils.waitFor(5);

        //alloverCommerceHomePage.SignOut_Link.click();

        alloverCommerceHomePage.signOut_Link.click();
        //alloverCommerceHomePage.SignOut_Link.click();

        //Click on Addresses Link
        AlloverCommerce_MyAccount_Page myAccountPage = new AlloverCommerce_MyAccount_Page();

        clickWithTimeoutByJS(myAccountPage.addressesLinkIcon);


        //Click on Edit Your Shipping Address link

        AlloverCommerce_MyAccountCustomerPage myAccountCustomerPage = new AlloverCommerce_MyAccountCustomerPage();
        clickWithTimeoutByJS(myAccountPage.editVendorShippingAddress);








    }
}

