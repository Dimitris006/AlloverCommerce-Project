package practice_.tests.US10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import practice_.pages.AlloverCommerce_VendorRegistration_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class Base {
    AlloverCommerce_VendorRegistration_Page vendorRegistrationPage;
    public void repeat(String pass) {
        Driver.getDriver().get("https://allovercommerce.com/vendor-register/");
        WaitUtils.waitForPageToLoad(15);

        //vendor object
        vendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();

        //Scroll to breadcrumb
        JSUtils.scrollIntoViewJS(
                vendorRegistrationPage.breadCrumb
        );

        WaitUtils.waitFor(2);

        //type password
        vendorRegistrationPage.vendorPassword.sendKeys(pass);
    }

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
}
