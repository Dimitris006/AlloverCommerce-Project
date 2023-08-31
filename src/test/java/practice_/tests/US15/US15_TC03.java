package practice_.tests.US15;

import org.testng.annotations.Test;
import practice_.pages.*;
import practice_.utilities.*;

public class US15_TC03 {

    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_VendorRegistration_Page vendorRegistrationPage;
    AlloverCommerce_MyAccount_Page accountPage;
    AlloverCommerce_Coupons_Page couponsPage;
    AlloverCommerce_ProductsManage productManage;

    @Test
    public void ProductOptions_shipping(){

        //Go to Homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //Create objects for pages

        alloverCommerceHomePage = new AlloverCommerce_HomePage();
        vendorRegistrationPage = new AlloverCommerce_VendorRegistration_Page();
        accountPage = new AlloverCommerce_MyAccount_Page();
        couponsPage = new AlloverCommerce_Coupons_Page();
        productManage = new AlloverCommerce_ProductsManage();

        //Click on Sign In Link
        alloverCommerceHomePage.signIn_Link.click();

        //Enter registered email into Username or email address field
        alloverCommerceHomePage.signIn_Username.sendKeys(ConfigReader.getProperty("vendor_email"));

        //Enter valid password into Password field
        alloverCommerceHomePage.signIn_Password.sendKeys(ConfigReader.getProperty("vendor_password"));

        //Click on Signin button
        alloverCommerceHomePage.signIn_Button.click();
        WaitUtils.waitFor(10);

        //Click on My Account link
        JSUtils.clickWithTimeoutByJS(alloverCommerceHomePage.myAccountLink);

        // Click on the 'Store Manager' link
        JSUtils.scrollIntoViewJS(accountPage.dashboardLink);
        JSUtils.clickWithTimeoutByJS(accountPage.storeManagerLink);
        WaitUtils.waitForPageToLoad(15);
        JSUtils.scrollIntoViewJS(accountPage.storeManagerLogo);
        WaitUtils.waitFor(1);

        // Click on 'Products'
        ActionsUtils.hoverOverOnElementActions(accountPage.productLink);

        // Click on 'Add new'
        WaitUtils.waitForVisibility(accountPage.addNewProduct, 5);
        accountPage.addNewProduct.click();

        String productName = "Iphone";
        productManage.productTitleInput.sendKeys(productName);
        WaitUtils.waitFor(5);

        //Click on shipping button

        JSUtils.clickWithTimeoutByJS(accountPage.shipping);
        WaitUtils.waitFor(2);

        accountPage.weight_kg.sendKeys("1000");

        WaitUtils.waitFor(2);

       accountPage.length.sendKeys("555");
        WaitUtils.waitFor(2);
        accountPage.width.sendKeys("666");
        WaitUtils.waitFor(2);
        accountPage.height.sendKeys("777");
        WaitUtils.waitFor(2);

        accountPage.shipping_class.click();
        WaitUtils.waitFor(2);
        accountPage.processing_time.click();

        //Verify the Shipping option is visible
        BrowserUtils.verifyElementDisplayed(accountPage.shipping);

        //Complete test and close browser
        WaitUtils.waitFor(3);
        //ExtentReportUtils.flush();
        Driver.closeDriver();

    }
}