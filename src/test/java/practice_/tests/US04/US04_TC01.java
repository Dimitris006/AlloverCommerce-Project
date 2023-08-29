package practice_.tests.US04;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_AddressesPage;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccountCustomerPage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;
import practice_.utilities.*;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;
import static practice_.utilities.JSUtils.clickWithTimeoutByJS;
public class US04_TC01 {


    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page myAccountPage;
    AlloverCommerce_AddressesPage alloverCommerceAddressesPage;

    @Test
    public void shippingAddress() throws IOException {

        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allover-commerce_url"));

        //Click on Register Link
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceHomePage.register_Link.click();

        //Enter username or email address
        alloverCommerceHomePage.signIn_Username.sendKeys("happypotter11@gmx.com");

        //Enter password
        alloverCommerceHomePage.signIn_Password.sendKeys("abc123456789");
        //Enter username
        Faker faker = new Faker();

        String username = faker.name().username();
        System.out.println(username);
        alloverCommerceHomePage.signUp_Username.sendKeys(username);

        //Enter email
        String emailAddress = faker.internet().emailAddress();
        System.out.println(emailAddress);
        alloverCommerceHomePage.signUp_Email.sendKeys(emailAddress);

        //Enter password
        String password = faker.internet().password();
        System.out.println(password);
        alloverCommerceHomePage.signUp_Password.sendKeys(password);
        //Click on Privacy Policy
        clickWithTimeoutByJS(alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox);

        //Click on Sign Up Button
        clickWithTimeoutByJS(alloverCommerceHomePage.signUp_Button);

        //Click on Sign Out Link
        WaitUtils.waitFor(5);

   //     alloverCommerceHomePage.SignOut_Link.click();
        alloverCommerceHomePage.signOut_Link.click();

        //Click on Addresses Link
        myAccountPage = new AlloverCommerce_MyAccount_Page();
        JSUtils.scrollIntoViewJS(myAccountPage.addressesLinkIcon);
        WaitUtils.waitForClickablility(myAccountPage.addressesLinkIcon);
        myAccountPage.addressesLinkIcon.click();

        //Click on Add Link at Shipping Address
        alloverCommerceAddressesPage =new AlloverCommerce_AddressesPage();
        alloverCommerceAddressesPage.shippingAddressAdd.click();


        //Insertion of Details
//        alloverCommerceAddressesPage.firstNameField.sendKeys(faker.name().firstName());
//        alloverCommerceAddressesPage.lastNameField.sendKeys(faker.name().lastName());
//        alloverCommerceAddressesPage.companyName.sendKeys(faker.name().name());
//        BrowserUtils.selectByValue(alloverCommerceAddressesPage.shipCountryDropdown, "GR");
//        alloverCommerceAddressesPage.streetAddress.sendKeys(faker.address().streetName());
//        alloverCommerceAddressesPage.cityName.sendKeys(faker.address().city());
////        BrowserUtils.selectByValue(alloverCommerceAddressesPage.stateDropdown, "GR");
//        alloverCommerceAddressesPage.zipCode.sendKeys(faker.address().zipCode());

        //Visibility of Save Address Button
        assertTrue(alloverCommerceAddressesPage.saveAddressButton.isDisplayed());
        clickWithTimeoutByJS(alloverCommerceAddressesPage.saveAddressButton);
        assertTrue(alloverCommerceAddressesPage.addressesHeader.isDisplayed());

        MediaUtils.takeScreenshotOfTheEntirePage();

        Driver.closeDriver();

    }
}
