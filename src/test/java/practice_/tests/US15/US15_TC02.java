package practice_.tests.US15;
import org.testng.annotations.Test;
import practice_.pages.*;
import practice_.utilities.*;

import static org.testng.AssertJUnit.assertTrue;
public class US15_TC02 {

    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_VendorRegistration_Page vendorRegistrationPage;
    AlloverCommerce_MyAccount_Page accountPage;
    AlloverCommerce_Coupons_Page couponsPage;
    AlloverCommerce_ProductsManage productManage;

    @Test
    public void ProductOptions_inventory(){

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

        //Click on My Account
        JSUtils.clickWithTimeoutByJS(alloverCommerceHomePage.myAccountLink);

        // Click on the 'Store Manager' link
        JSUtils.scrollIntoViewJS(accountPage.dashboardLink);
        JSUtils.clickWithTimeoutByJS(accountPage.storeManagerLink);
        WaitUtils.waitForPageToLoad(5);
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

        //Click on Inventory button
        JSUtils.clickWithTimeoutByJS(accountPage.inventory);
        WaitUtils.waitFor(2);

        //Click on SKU field and enter data
        accountPage.sku_field.sendKeys("456789");
        WaitUtils.waitFor(2);

        //Click on Manage Stock? button
        accountPage.manage_stock.click();
        WaitUtils.waitFor(2);

        //Click on Stock Qty field
        accountPage.stock_qty.sendKeys("55");
        WaitUtils.waitFor(2);

        //click on in  allow_backorders? drop-down button and select the data.
       accountPage.allow_backorders.click();
        WaitUtils.waitFor(2);

        //Click the Sold Individually button
        accountPage.sold_individually.click();
        WaitUtils.waitFor(2);

        //Verify the inventory is seen
        BrowserUtils.verifyElementDisplayed(accountPage.inventory);

       //Complete test and close browser
        WaitUtils.waitFor(3);
        //ExtentReportUtils.flush();
        Driver.closeDriver();
    }
}