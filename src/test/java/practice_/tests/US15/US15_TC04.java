package practice_.tests.US15;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import practice_.pages.*;
import practice_.utilities.*;

import java.io.IOException;

public class US15_TC04 {

    AlloverCommerce_HomePage alloverCommerceHomePage;
    AlloverCommerce_VendorRegistration_Page vendorRegistrationPage;
    AlloverCommerce_MyAccount_Page accountPage;
    AlloverCommerce_Coupons_Page couponsPage;
    AlloverCommerce_ProductsManage productManage;

    @Test
    public void ProductOptions_shipping() {

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
        JSUtils.clickWithTimeoutByJS(accountPage.attributes);
        WaitUtils.waitFor(5);

        JSUtils.clickWithTimeoutByJS(accountPage.colorcheckbox);
        WaitUtils.waitFor(2);

        Select select = new Select(Driver.getDriver().findElement(By.xpath("(//select)[10]")));

        select.selectByValue("305");

        try {
            MediaUtils.takeScreenshotOfThisElement(Driver.getDriver().findElement(By.xpath("(//select)[10]")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        WaitUtils.waitFor(10);
        JSUtils.clickWithTimeoutByJS(accountPage.sizecheckbox);
        WaitUtils.waitFor(2);

        Select select1 = new Select(Driver.getDriver().findElement(By.xpath("(//select)[11]")));

        select1.selectByValue("749");
        WaitUtils.waitFor(10);
        try {
            MediaUtils.takeScreenshotOfThisElement(Driver.getDriver().findElement(By.xpath("(//select)[11]")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            MediaUtils.takeScreenshotOfTheEntirePageAsString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Complete test and close browser
        WaitUtils.waitFor(3);
        Driver.closeDriver();
    }
}