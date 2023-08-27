package practice_.tests.US01;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.*;

import static practice_.utilities.JSUtils.clickWithTimeoutByJS;

public class US01_TC01 {
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;


        @Test
        public void TC01() {

                alloverCommerceHomePage = new AlloverCommerce_HomePage();
                alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
                alloverCommerceHomePage.register_Link.click();
                alloverCommerceHomePage.signUp_Username.sendKeys("osman123");
                alloverCommerceHomePage.signUp_Email.sendKeys("osman@gfd.com");
                alloverCommerceHomePage.signUp_Password.sendKeys("Jackdoe1234.");
                alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
                clickWithTimeoutByJS(alloverCommerceHomePage.signUp_Button);
                WaitUtils.waitFor(2);
                BrowserUtils.verifyElementDisplayed(alloverCommerceHomePage.signOut_Link);
                Driver.closeDriver();

        }
}
