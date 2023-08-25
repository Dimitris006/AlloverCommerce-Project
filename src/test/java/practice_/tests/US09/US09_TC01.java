
package practice_.tests.US09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.VendorRegistration_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

import static org.testng.AssertJUnit.assertTrue;


public class US09_TC01 {
   AlloverCommerce_HomePage alloverCommerceHomePage;
   VendorRegistration_Page vendorRegistrationPage;
   @Test
    public void vendorSignUp(){
       // Go to home page
       Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

       // Creating page Object
       AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
       VendorRegistration_Page vendorRegistrationPage = new VendorRegistration_Page();


       //Click on Register link
       alloverCommerceHomePage.register_Link.click();

       //Click on "Become Vendor" link
       alloverCommerceHomePage.signUp_BecomeVendorLink.click();

       //Enter email in email field
       vendorRegistrationPage.vendorRegister_Email.sendKeys(ConfigReader.getProperty("vendor_email"));

       // Confirm the Verification code message is visible
       Assert.assertTrue(vendorRegistrationPage.verificationCodeMessage.isDisplayed());

       //Enter verification code in the Verification Code text box
      vendorRegistrationPage.verificationCode.sendKeys(ConfigReader.getProperty("verification_code"));

      //Enter valid password in Password field
      vendorRegistrationPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendor_password"));

      //Enter password into Confirm Password field
      vendorRegistrationPage.vendorConfirmPassword.sendKeys(ConfigReader.getProperty("vendor_password"));

      //Click on Register button
      vendorRegistrationPage.registerButton.click();







   }
}
