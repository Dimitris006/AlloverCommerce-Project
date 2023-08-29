package practice_.tests.US12;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_AddressesPage;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.*;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;
import static practice_.utilities.JSUtils.clickWithTimeoutByJS;

public class US12_TC02 {

    WebDriver driver;
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page myAccountPage;
    AlloverCommerce_AddressesPage alloverCommerceAddressesPage;

    @Test
    public void BillingAddress01() throws IOException {

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
        alloverCommerceHomePage.signOut_Link.click();

        //Click on Addresses Link
        myAccountPage = new AlloverCommerce_MyAccount_Page();
        clickWithTimeoutByJS(myAccountPage.addressesLinkIcon);

        //Click on Add Link at Shipping Address
        alloverCommerceAddressesPage =new AlloverCommerce_AddressesPage();
        clickWithTimeoutByJS(alloverCommerceAddressesPage.billingAddressAdd);

        //Insertion of Details

        alloverCommerceAddressesPage.billCompanyName.sendKeys("One");
        BrowserUtils.selectByValue(alloverCommerceAddressesPage.billCountryDropdown, "GR");
        alloverCommerceAddressesPage.billStreetAddress.sendKeys("Home 2");
        alloverCommerceAddressesPage.billCityName.sendKeys("Village");
//        BrowserUtils.selectByValue(alloverCommerceAddressesPage.stateDropdown, "GR");
        alloverCommerceAddressesPage.billZipCode.sendKeys("11333");
        alloverCommerceAddressesPage.billPhone.sendKeys("0001110001");

        //Visibility of Save Address Button
//        assertTrue(alloverCommerceAddressesPage.billSaveAddressButton.isDisplayed());
//        clickWithTimeoutByJS(alloverCommerceAddressesPage.billSaveAddressButton);

        //Visibility of Successful Adding
        Assert.assertTrue((alloverCommerceAddressesPage.successfulAdd).isDisplayed());

        MediaUtils.takeScreenshotOfTheEntirePage();

        Driver.closeDriver();

    }
}