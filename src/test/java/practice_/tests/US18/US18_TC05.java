package practice_.tests.US18;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_Coupons_Page;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.pages.AlloverCommerce_VendorRegistration_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;
import java.util.List;

public class US18_TC05 {

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

        //Enter code into the Code field
        //CREATING ACCOUNT WITH JAVA FAKER
        Faker faker = new Faker();
        String couponCode = faker.code().ean8();
        couponsPage.codeTextField.sendKeys(couponCode);
        WaitUtils.waitFor(3);

        //Enter description into Description field
        couponsPage.descriptionTextField.sendKeys("This is description text for the coupon");
        WaitUtils.waitFor(3);

        //Enter coupon amount
        String couponAmount = String.valueOf(faker.number().randomDigit());
        couponsPage.couponAmountTextField.sendKeys(couponAmount);
        WaitUtils.waitFor(3);

        //Click on SUBMIT
        JSUtils.scrollIntoViewJS(couponsPage.couponSubmitButton);
        JSUtils.clickWithTimeoutByJS(couponsPage.couponSubmitButton);
        WaitUtils.waitFor(3);

        //Click on Coupons link
        JSUtils.clickWithTimeoutByJS(couponsPage.couponsLink);
        WaitUtils.waitFor(3);

       //Locate the list of coupon codes and put all codes into a list
       List<WebElement> couponsList = Driver.getDriver().findElements(By.xpath("(//tbody)[1]/tr/td[1]"));

        boolean couponCodeFound = false;

        // Iterate through the list of coupon codes
        for (WebElement couponCodeElement : couponsList) {
            String createdCouponCode = couponCodeElement.getText();
            if (createdCouponCode.equals(couponCode)) {
                couponCodeFound = true;
                break;
            }
        }

        // Assert whether the coupon code was found in the list
        if (couponCodeFound) {
            System.out.println("Coupon code found in the list.");
        } else {
            System.out.println("Coupon code not found in the list.");
        }


        //Complete test and close browser
        WaitUtils.waitFor(3);
        //ExtentReportUtils.flush();
        Driver.closeDriver();
    }
}
