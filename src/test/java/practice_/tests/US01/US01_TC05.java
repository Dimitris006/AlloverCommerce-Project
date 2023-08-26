package practice_.tests.US01;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.BrowserUtils;
import practice_.utilities.ConfigReader;
import practice_.utilities.Driver;
import practice_.utilities.WaitUtils;

import java.time.Duration;

public class US01_TC05 {
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;
        @Test
        public void TC05() {

                alloverCommerceHomePage = new AlloverCommerce_HomePage();
                alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
                alloverCommerceHomePage.register_Link.click();
                alloverCommerceHomePage.signUp_Username.sendKeys("4seasons");
                alloverCommerceHomePage.signUp_Email.sendKeys("4seasons@gfd.com");
                alloverCommerceHomePage.signUp_Password.sendKeys("JANEDOE1234.");
                alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
                alloverCommerceHomePage.signUp_Button.click();
                WaitUtils.waitFor(2);
                BrowserUtils.verifyElementDisplayed(alloverCommerceHomePage.signOut_Link);
                Driver.closeDriver();

        }
}
