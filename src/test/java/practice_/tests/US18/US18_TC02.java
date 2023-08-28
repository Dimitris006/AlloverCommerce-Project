package practice_.tests.US18;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Coupons_Page;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.pages.AlloverCommerce_VendorRegistration_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.AssertJUnit.assertTrue;

public class US18_TC02 {

    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_VendorRegistration_Page vendorRegistrationPage;
    AlloverCommerce_MyAccount_Page myAccountPage;
    AlloverCommerce_Coupons_Page couponsPage;

    @Test
    public void vendorSignIn(){

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Create objects for pages
        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        vendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();
        myAccountPage = new AlloverCommerce_MyAccount_Page();
        couponsPage = new AlloverCommerce_Coupons_Page();

        //Click on Sign In Link
        alloverCommerceHomePage.signIn_Link.click();

        //Enter registered email into Username or email address field
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter valid password into Password field
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on Signin button
        alloverCommerceHomePage.signIn_Button.click();
        WaitUtils.waitFor(3);

        //Click on My Account link
        JSUtils.scrollIntoViewJS(vendorRegistrationPage.myAccountLink);
        WaitUtils.waitForClickablility(vendorRegistrationPage.myAccountLink, 2).click();

        //Click on Store Manager link
        myAccountPage.storeManagerLink.click();

        //Click on Coupons link
        JSUtils.clickWithTimeoutByJS(couponsPage.couponsLink);

        //Click on Add New button
        couponsPage.addCouponButton.click();

        //Enter description into Description field
        couponsPage.descriptionTextField.sendKeys("This is description text for the coupon");

        //Enter coupon amount
        //CREATING ACCOUNT WITH JAVA FAKER
        Faker faker = new Faker();
        String couponAmount = String.valueOf(faker.number().randomDigit());
        couponsPage.couponAmountTextField.sendKeys(couponAmount);

        //Enter expiry date
        // Generate a random date within the specified range
        Date startDate = new Date(123, 9, 10); // Oct 10, 2023
        Date endDate = new Date(124, 10, 11); // Nov 11, 2024
        Date randomDate = faker.date().between(startDate, endDate);

        // Convert the date to a string using SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String expiryDate = dateFormat.format(randomDate);
        couponsPage.expiryDateField.sendKeys(expiryDate);

        //Click on SUBMIT
        JSUtils.scrollIntoViewJS(couponsPage.couponSubmitButton);
        JSUtils.clickWithTimeoutByJS(couponsPage.couponSubmitButton);
        WaitUtils.waitFor(3);

        //Verify Please insert atleast Coupon Title before submit. message is displayed
        assertTrue(couponsPage.missingCouponTitleErrorMessage.isDisplayed());

        //Complete test and close browser
        WaitUtils.waitFor(3);
        //ExtentReportUtils.flush();
        Driver.closeDriver();
    }
}
