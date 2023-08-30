package practice_.tests.US14;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.JSUtils;
import practice_.utilities.WaitUtils;

public class RepeatedSignIn {
    AlloverCommerce_HomePage acHomepage;
    AlloverCommerce_MyAccount_Page accountPage;
    public void repeatedSignIn() {
        acHomepage = new AlloverCommerce_HomePage();
        accountPage = new AlloverCommerce_MyAccount_Page();
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
    }
}
