package practice_.tests.US11;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_VendorRegistration_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.ExtentReportUtils;
import practice_.utilities.WaitUtils;

import static org.testng.AssertJUnit.assertTrue;
import static practice_.utilities.ExtentReportUtils.passAndCaptureScreenshot;

public class US11_TC01 {

    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_VendorRegistration_Page vendorRegistrationPage;

    @Test
    public void vendorSignIn(){

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Create allovercommerce homepage and vendor registration object
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        vendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        //Click on Sign In Link
        alloverCommerceHomePage.signIn_Link.click();

        //Enter registered email into Username or email address field
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter valid password into Password field
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on Signin button
        alloverCommerceHomePage.signIn_Button.click();
        WaitUtils.waitFor(3);
        //ExtentReportUtils.passAndCaptureScreenshot("My Account page should be displayed...");

        //Verify My Account is displayed
        assertTrue(Driver.getDriver().getCurrentUrl().contains("my account"));

        //Complete test and close browser
        WaitUtils.waitFor(2);
        //ExtentReportUtils.flush();
        Driver.closeDriver();
    }
}

