package practice_.tests.US11;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.VendorRegister_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

public class US11_TC01 {

    AlloverCommerce_HomePage alloverCommerceHomePage;
    VendorRegister_Page vendorRegisterPage;

    @Test
    public void vendorSignin(){

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Click on Register link
        alloverCommerceHomePage.register_Link.click();

        //Click on Signup as a vendor? link
        alloverCommerceHomePage.signUp_AsVendorLink.click();

        //Enter email in the Email field
        vendorRegisterPage.vendorRegister_Email.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter code into Verification Code field
        vendorRegisterPage.verificationCode.sendKeys(ConfigReader.getProperty("verification_code"));

        //Enter valid password in Password field
        vendorRegisterPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Enter password into Confirm Password field
        vendorRegisterPage.vendorConfirmPassword.sendKeys("vendor_password");

        //Click on Register button
        vendorRegisterPage.registerButton.click();

        //Click on NOT RIGHT NOW button
        vendorRegisterPage.notRightNowButton.click();

        //Verify My Account is displayed
        assertTrue(vendorRegisterPage.myAccountLink.isDisplayed());
    }
}

