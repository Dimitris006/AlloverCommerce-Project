package practice_.tests.US04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_AddressesPage;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.*;

import static practice_.utilities.JSUtils.clickWithTimeoutByJS;


public class US04_TC01 {

    WebDriver driver;
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page myAccountPage;
    AlloverCommerce_AddressesPage alloverCommerceAddressesPage;

    @Test
    public void shippingAddress01(){

        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Sign In Link
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceHomePage.signIn_Link.click();

        //Enter username or email address
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("customer_email"));

        //Enter password
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("customer_password"));

        //Click on Sign In Button
        alloverCommerceHomePage.signIn_Button.click();

        //Click on Sign Out Link
        WaitUtils.waitFor(5);

        //alloverCommerceHomePage.SignOut_Link.click();

        alloverCommerceHomePage.signOut_Link.click();
        //alloverCommerceHomePage.SignOut_Link.click();

        //Click on Addresses Link
        myAccountPage = new AlloverCommerce_MyAccount_Page();
        clickWithTimeoutByJS(myAccountPage.addressesLinkIcon);

        //Click on Add Link at Shipping Address
        alloverCommerceAddressesPage =new AlloverCommerce_AddressesPage();
        clickWithTimeoutByJS(alloverCommerceAddressesPage.shippingAddressAdd);

        //Insertion of Details
        alloverCommerceAddressesPage.firstNameField.sendKeys("John");
        alloverCommerceAddressesPage.lastNameField.sendKeys("Neo");
        alloverCommerceAddressesPage.companyName.sendKeys("Pieces");
//        BrowserUtils.selectDropdownByValue(AlloverCommerce_AddressesPage(alloverCommerceAddressesPage.countryDropdwn), String "Afghanistan");
        alloverCommerceAddressesPage.streetAddress.sendKeys("Home 1");
        alloverCommerceAddressesPage.cityName.sendKeys("City");
//        BrowserUtils.selectDropdownByValue;
        alloverCommerceAddressesPage.zipCode.sendKeys("33111");


    }
}
