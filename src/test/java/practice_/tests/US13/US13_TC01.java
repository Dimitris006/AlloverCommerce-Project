package practice_.tests.US13;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_AddressesPage;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccountCustomerPage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;
import static practice_.utilities.JSUtils.clickWithTimeoutByJS;

public class US13_TC01 {
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page myAccountPage;
    AlloverCommerce_AddressesPage alloverCommerceAddressesPage;

    @Test
    public void vendorAccountNavigation() {

        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Sign In Link
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceHomePage.signIn_Link.click();

        //Enter username or email address
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter password
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on Sign In Button
        alloverCommerceHomePage.signIn_Button.click();

        //Click on Sign Out Link
        WaitUtils.waitFor(5);
        // alloverCommerceHomePage.signOut_Link.click();

        myAccountPage = new AlloverCommerce_MyAccount_Page();
        clickWithTimeoutByJS(alloverCommerceHomePage.myAccountLink);
        WaitUtils.waitFor(5);

        clickWithTimeoutByJS(myAccountPage.addressesLinkIcon);

        //Click on Add Link at Shipping Address
        alloverCommerceAddressesPage = new AlloverCommerce_AddressesPage();
        clickWithTimeoutByJS(alloverCommerceAddressesPage.shippingAddressAdd);


    }
}


