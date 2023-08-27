package practice_.tests.US01;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

import static practice_.utilities.JSUtils.clickWithTimeoutByJS;

public class US01_TC02 {
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;


        @Test
        public void TC02() {

                alloverCommerceHomePage = new AlloverCommerce_HomePage();
                alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
                alloverCommerceHomePage.register_Link.click();
                alloverCommerceHomePage.signUp_Username.sendKeys("Osman_3");
                alloverCommerceHomePage.signUp_Email.sendKeys("osman_3@gfd");
                alloverCommerceHomePage.signUp_Password.sendKeys("Jackdoe1234.");
                alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
                clickWithTimeoutByJS(alloverCommerceHomePage.signUp_Button);
                WaitUtils.waitFor(2);
                //BrowserUtils.verifyElementDisplayed(alloverCommerceHomePage.signUp_invalidEmailMessage);
                Assert.assertTrue(alloverCommerceHomePage.signUp_invalidEmailMessage.isDisplayed());
                Driver.closeDriver();

        }
}
