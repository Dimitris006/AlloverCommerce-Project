package practice_.tests.US01;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

import java.time.Duration;

import static practice_.utilities.JSUtils.clickWithTimeoutByJS;

public class US01_TC03 {
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;
        @Test
        public void TC03() {

                alloverCommerceHomePage = new AlloverCommerce_HomePage();
                alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
                alloverCommerceHomePage.register_Link.click();
                alloverCommerceHomePage.signUp_Username.sendKeys("winter");
                alloverCommerceHomePage.signUp_Email.sendKeys("winter@gfd.com");
                alloverCommerceHomePage.signUp_Password.sendKeys("Jack");
                alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
                WaitUtils.waitFor(2);
                BrowserUtils.verifyElementNotClickable(alloverCommerceHomePage.signUp_Button);
                Driver.closeDriver();

        }
}
