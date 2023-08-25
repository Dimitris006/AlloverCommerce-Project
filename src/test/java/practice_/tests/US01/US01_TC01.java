package practice_.tests.US01;

import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.MyAccount_Page;
import practice_.utilities.*;

public class US01_TC01 {
        AlloverCommerce_HomePage alloverCommerceHomePage;

        @Test
        public void appLoginTest() {

                alloverCommerceHomePage = new AlloverCommerce_HomePage();
                myAccountPage = new MyAccount_Page();

                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
                alloverCommerceHomePage.register_Link.click();
                alloverCommerceHomePage.signUp_Username.sendKeys("TOM999");
                alloverCommerceHomePage.signUp_Email.sendKeys("tom@gfd.com");
                alloverCommerceHomePage.signUp_Password.sendKeys("Jackdoe1234.");
                alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
                alloverCommerceHomePage.signUp_Button.click();
                WaitUtils.waitFor(2);
                BrowserUtils.verifyElementDisplayed(alloverCommerceHomePage.signOut_button);

                alloverCommerceHomePage.signOut_button.click();
                myAccountPage.logOut_Button.click();

                BrowserUtils.verifyElementDisplayed(alloverCommerceHomePage.register_Link);
                WaitUtils.waitFor(2);
                Driver.closeDriver();

        }
}
