package practice_.tests.US04;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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


public class US04_TC03 {
    WebDriver driver;
    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_MyAccount_Page myAccountPage;
    AlloverCommerce_AddressesPage alloverCommerceAddressesPage;

    @Test
    public void shippingAddress03() throws IOException {

        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Register Link
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        alloverCommerceHomePage.register_Link.click();

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
        alloverCommerceHomePage.signOut_Link.click();

        //Click on Addresses Link
        myAccountPage = new AlloverCommerce_MyAccount_Page();
        clickWithTimeoutByJS(myAccountPage.addressesLinkIcon);

        //Click on Add Link at Shipping Address
        alloverCommerceAddressesPage =new AlloverCommerce_AddressesPage();
        clickWithTimeoutByJS(alloverCommerceAddressesPage.shippingAddressAdd);

        //Click on Save Address Button
        clickWithTimeoutByJS(alloverCommerceAddressesPage.saveAddressButton);

        //Visibility of Invalid Information Messages
//        BrowserUtils.verifyElementDisplayed(alloverCommerceAddressesPage.firstNameWrong);
//        BrowserUtils.verifyElementDisplayed(alloverCommerceAddressesPage.lastNameWrong);
//        BrowserUtils.verifyElementDisplayed(alloverCommerceAddressesPage.countryWrong);
//        BrowserUtils.verifyElementDisplayed(alloverCommerceAddressesPage.addressWrong);
//        BrowserUtils.verifyElementDisplayed(alloverCommerceAddressesPage.cityWrong);
//        BrowserUtils.verifyElementDisplayed(alloverCommerceAddressesPage.stateWrong);
//        BrowserUtils.verifyElementDisplayed(alloverCommerceAddressesPage.postcodeWrong);

        MediaUtils.takeScreenshotOfTheEntirePage();

        Driver.closeDriver();

    }
}
