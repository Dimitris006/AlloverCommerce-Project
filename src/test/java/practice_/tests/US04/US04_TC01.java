package practice_.tests.US04;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_AddressesPage;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class US04_TC01 {


    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page myAccountPage;
    AlloverCommerce_AddressesPage alloverCommerceAddressesPage;

    @Test
    public void shippingAddress(){

        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Sign In Link
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceHomePage.signIn_Link.click();

        //Enter username or email address
        alloverCommerceHomePage.signIn_Username.sendKeys("happypotter11@gmx.com");

        //Enter password
        alloverCommerceHomePage.signIn_Password.sendKeys("abc123456789");

        //Click on Sign In Button
        alloverCommerceHomePage.signIn_Button.click();

        //Click on Sign Out Link
        WaitUtils.waitFor(5);
<<<<<<< HEAD
        alloverCommerceHomePage.signOut_Link.click();
=======
        //alloverCommerceHomePage.SignOut_Link.click();
>>>>>>> 7c9aa48 (Add US01 test cases)

        //Click on Addresses Link
        myAccountPage = new AlloverCommerce_MyAccount_Page();
        JSUtils.scrollIntoViewJS(myAccountPage.addressesLinkIcon);
        WaitUtils.waitForClickablility(myAccountPage.addressesLinkIcon);
        myAccountPage.addressesLinkIcon.click();

        //Click on Add Link at Shipping Address
        alloverCommerceAddressesPage =new AlloverCommerce_AddressesPage();
        alloverCommerceAddressesPage.shippingAddressAdd.click();












    }
}
