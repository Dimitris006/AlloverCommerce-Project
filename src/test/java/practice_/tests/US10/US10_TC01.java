package practice_.tests.US10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_VendorRegistration_Page;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

import javax.print.attribute.standard.Media;
import java.io.IOException;

public class US10_TC01 {

    @Test
    public void tc01() throws IOException {
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        //navigate to vendor registration page
        Driver.getDriver().get("https://allovercommerce.com/vendor-register/");

        JSUtils.scrollIntoViewJS(
                alloverCommerceVendorRegistrationPage.breadCrumb
        );

        WaitUtils.waitFor(2);

        //too short password [5 characters long]
        alloverCommerceVendorRegistrationPage.vendorPassword.sendKeys("12345");

        checkInputField();
        WaitUtils.waitFor(2);

        Assert.assertEquals(
                alloverCommerceVendorRegistrationPage.vendorPasswordStrength.getText(),
                "Too short"
        );

        clearPasswordField();
        WaitUtils.waitFor(1);
    }

    @Test
    public void tc02() throws IOException {
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        //weak password [6 characters long]
        alloverCommerceVendorRegistrationPage.vendorPassword.sendKeys("12345@");

        WaitUtils.waitFor(2);

        Assert.assertEquals(
                alloverCommerceVendorRegistrationPage.vendorPasswordStrength.getText(),
                "Weak"
        );

        clearPasswordField();
        WaitUtils.waitFor(1);

    }

    @Test
    public void tc03() throws IOException {
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        //good password [8+ characters long + at least one special character]
        alloverCommerceVendorRegistrationPage.vendorPassword.sendKeys("12345@13456789876545678765456");

        WaitUtils.waitFor(2);

        Assert.assertEquals(
                alloverCommerceVendorRegistrationPage.vendorPasswordStrength.getText(),
                "Good"
        );

        clearPasswordField();
        WaitUtils.waitFor(1);

    }

    @Test
    public void tc04() throws IOException {
        AlloverCommerce_VendorRegistration_Page alloverCommerceVendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        //good password [8+ characters long + at least two special character]
        //doesn't have to be a combination of special characters
        alloverCommerceVendorRegistrationPage.vendorPassword.sendKeys("12345@!$");

        WaitUtils.waitFor(2);

        Assert.assertEquals(
                alloverCommerceVendorRegistrationPage.vendorPasswordStrength.getText(),
                "Strong"
        );


        WaitUtils.waitFor(1);

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
    public static void tearUp() {
        Driver.closeDriver();
    }
}
