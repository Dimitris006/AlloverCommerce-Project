package practice_.tests.US10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_VendorRegistration_Page;
import practice_.utilities.Driver;
import practice_.utilities.ExtentReportUtils;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;
import java.io.IOException;

public class US10_TC01 {

    ExtentReportUtils extentReportUtils = new ExtentReportUtils();
    @BeforeSuite
    public void setExtentReportConfigurations() {

        //Set the custom file path
        //6 character hash code will be added after the name
        ExtentReportUtils.screenshotFilePathName("AlloverCommerce");

        //Set meta-data
        //All this will appear in the dashboard view
        extentReportUtils.addCustomSystemInfo("Application Name", "Allover Commerce Website");
        extentReportUtils.addCustomSystemInfo("Browser", "Chrome");
        extentReportUtils.addCustomSystemInfo("Team Name", "Potter");
        extentReportUtils.addCustomSystemInfo("SQA", "Faik");
        extentReportUtils.addCustomSystemInfo("Issue", "AC-18");

        // Set the report name and document title
        extentReportUtils.setReportInfo("Smoke Test Report", "Smoke Extent Reports");

        //The test entry would appear in the report’s table of contents,
        // and its details would be displayed in the main report body when the test entry is selected.
        ExtentReportUtils.createTestReport("Password security levels (US_10)", "Smoke Test");
    }

    @Test
    public void tc01() throws IOException {
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        ExtentReportUtils.info("Beginning test case 1...");
        //navigate to vendor registration page
        Driver.getDriver().get("https://allovercommerce.com/vendor-register/");
        ExtentReportUtils.pass("Navigating to the vendor registration page");

        JSUtils.scrollIntoViewJS(
                alloverCommerceVendorRegistrationPage.breadCrumb
        );

        WaitUtils.waitFor(2);

        //too short password [5 characters long]
        ExtentReportUtils.info("Entering a short password");
        alloverCommerceVendorRegistrationPage.vendorPassword.sendKeys("12345");

        checkInputField();
        WaitUtils.waitFor(2);

        Assert.assertEquals(
                alloverCommerceVendorRegistrationPage.vendorPasswordStrength.getText(),
                "Too short"
        );
        ExtentReportUtils.passAndCaptureScreenshot("Password security level displays correct message: 'Too short'");

        ExtentReportUtils.info("Password field is cleared");
        clearPasswordField();
        WaitUtils.waitFor(1);
    }


    @Test
    public void tc02() throws IOException {

        ExtentReportUtils.info("Beginning test case 2...");
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        //weak password [6 characters long]
        ExtentReportUtils.info("Entering a Weak password");
        alloverCommerceVendorRegistrationPage.vendorPassword.sendKeys("12345@");

        WaitUtils.waitFor(2);

        Assert.assertEquals(
                alloverCommerceVendorRegistrationPage.vendorPasswordStrength.getText(),
                "Weak"
        );
        ExtentReportUtils.passAndCaptureScreenshot("Password security level displays correct message: 'Weak'");

        ExtentReportUtils.info("Password field is cleared");
        clearPasswordField();

        WaitUtils.waitFor(1);
    }

    @Test
    public void tc03() throws IOException {
        ExtentReportUtils.info("Beginning test case 3...");
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        //good password [8+ characters long + at least one special character]
        ExtentReportUtils.info("Entering a 'Good' password");
        alloverCommerceVendorRegistrationPage.vendorPassword.sendKeys("1234567@");

        WaitUtils.waitFor(2);

        Assert.assertEquals(
                alloverCommerceVendorRegistrationPage.vendorPasswordStrength.getText(),
                "Good"
        );
        ExtentReportUtils.passAndCaptureScreenshot("Password security level displays correct message: 'Good'");

        ExtentReportUtils.info("Password field is cleared");
        clearPasswordField();

        WaitUtils.waitFor(1);
    }

    @Test
    public void tc04() throws IOException {
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        //'Strong' password [8+ characters long + at least two special character]
        //doesn't have to be a combination of special characters
        ExtentReportUtils.info("Entering a 'Strong' password");
        alloverCommerceVendorRegistrationPage.vendorPassword.sendKeys("12345@!$");

        WaitUtils.waitFor(2);

        Assert.assertEquals(
                alloverCommerceVendorRegistrationPage.vendorPasswordStrength.getText(),
                "Strong"
        );
        ExtentReportUtils.passAndCaptureScreenshot("Password security level displays correct message: 'Strong'");
        ExtentReportUtils.warning("Repetitive special characters can still trigger 'Strong' password");

        WaitUtils.waitFor(1);
        ExtentReportUtils.info("Test end...");
    }

    /**
     * ================= METHODS =====================================
     */

    public void checkInputField() {
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        WebElement passwordField = alloverCommerceVendorRegistrationPage.vendorPassword;

        if(passwordField.getAttribute("type").equals("password")) {

            // Change type to text
            js.executeScript("arguments[0].type='text';", passwordField);

            // Get value
            String passwordText = (String) js.executeScript("return arguments[0].value;", passwordField);

            System.out.println(passwordText);

        }
    }

    public void clearPasswordField() {
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();
        //Java example
        WebElement passwordField = alloverCommerceVendorRegistrationPage.vendorPassword;

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Set value
        js.executeScript("arguments[0].value = arguments[1];",
                passwordField, "");
    }

    //can change back to password field if needed
//    public void changeToPasswordField() {
//        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//
//        WebElement passwordField = alloverCommerceVendorRegistrationPage.vendorPassword;
//        js.executeScript("arguments[0].type='password';", passwordField);
//        System.out.println("Changed back to text field");
//    }


/**
 * ================= @AfterSuite =====================================
 */

    @AfterSuite
    public void tearDown() {
        Driver.closeDriver();
        ExtentReportUtils.flush();
    }
}
