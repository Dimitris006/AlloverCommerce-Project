package practice_.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.pages.AlloverCommerce_ProductsManage;
import practice_.utilities.*;

import java.util.List;

public class US14_TC01 {

    AlloverCommerce_HomePage acHomepage;
    AlloverCommerce_MyAccount_Page accountPage;
    AlloverCommerce_ProductsManage productsManage;

    @Test
    public void tc01_affiliateProductOptions() {
        accountPage = new AlloverCommerce_MyAccount_Page();
        productsManage = new AlloverCommerce_ProductsManage();
        acHomepage = new AlloverCommerce_HomePage();
        //1. go homepage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));

        //2. scroll dow to footer to locate 'My Account'
        JSUtils.scrollIntoViewJS(acHomepage.myAccountLink_Footer);
        Assert.assertTrue(acHomepage.myAccountLink_Footer.isDisplayed());

        //3. click on 'My Account' link
        WaitUtils.waitForClickablility(acHomepage.myAccountLink_Footer, 15);
        WaitUtils.waitFor(1);
        acHomepage.myAccountLink_Footer.click();

        //Wait for the page https://allovercommerce.com/my-account-2/ to load
        WaitUtils.waitForPageToLoad(15);

        //4. Confirm that the correct page is loaded
        Assert.assertEquals(
                Driver.getDriver().getCurrentUrl(),
                "https://allovercommerce.com/my-account-2/"
        );

        //5. Confirm that sign-in tab is active on customer login popup
        Assert.assertTrue(acHomepage.signIn_Button.isDisplayed());

        //6. Enter username in the customer login popup
        acHomepage.signIn_Username.sendKeys(
                ConfigReader.getProperty("vendor_email")
        );

        //7. Enter vendor password in the customer login popup
        acHomepage.signIn_Password.sendKeys(
                ConfigReader.getProperty("vendor_password")
        );

        //8. Click on the 'SIGN IN' button
        JSUtils.scrollIntoViewJS(acHomepage.signIn_Button);
        WaitUtils.waitFor(1);
        acHomepage.signIn_Button.click();

        //9. Confirm that 'My Account' Dashboard is showing
        WaitUtils.waitForVisibility(accountPage.storeManagerLink, 15);
        Assert.assertTrue(accountPage.dashboardLink.isDisplayed());
        Assert.assertEquals(
                Driver.getDriver().getCurrentUrl(),
                "https://allovercommerce.com/my-account-2/"
        );

        WaitUtils.waitFor(1);

        //10. Click on the 'Store Manager' link
        JSUtils.scrollIntoViewJS(accountPage.dashboardLink);
        JSUtils.clickWithTimeoutByJS(accountPage.storeManagerLink);
        WaitUtils.waitForPageToLoad(15);
        JSUtils.scrollIntoViewJS(accountPage.storeManagerLogo);
        WaitUtils.waitFor(1);

        //11. Hover over 'Products'
        ActionsUtils.hoverOverOnElementActions(accountPage.productLink);

        //12. Click on 'Add new'
        WaitUtils.waitForVisibility(accountPage.addNewProduct, 15);
        accountPage.addNewProduct.click();

        //13. Confirm that there is a select input with the 'Simple Product' option selected
        WaitUtils.waitForPageToLoad(15);
        Assert.assertEquals(
                Driver.getDriver().getCurrentUrl(),
                "https://allovercommerce.com/store-manager/products-manage/"
        );

        //14. Click the select input at the top and confirm
        // (Simple Product, Variable Product, Grouped Product, External - Affiliate Product)
        // options ALL exist
        Select select = new Select(productsManage.productSelectInput);
        List<WebElement> selectOptions = select.getOptions();
        Assert.assertEquals(
                selectOptions.get(0).getText(),
                "Simple Product"
        );
        System.out.println(selectOptions.get(0).getText());
    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }
}