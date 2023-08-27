package practice_.tests.US01;

import org.testng.Assert;
import org.testng.annotations.Test;
import practice_.pages.AlloverCommerce_HomePage;
import practice_.pages.AlloverCommerce_MyAccount_Page;
import practice_.utilities.*;

public class US01_TC07 {
        AlloverCommerce_HomePage alloverCommerceHomePage;
        AlloverCommerce_MyAccount_Page alloverCommerceMyAccountPage;
        @Test
        public void TC07() {

                alloverCommerceHomePage = new AlloverCommerce_HomePage();
                alloverCommerceMyAccountPage = new AlloverCommerce_MyAccount_Page();

                Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
                alloverCommerceHomePage.register_Link.click();
                alloverCommerceHomePage.signUp_Username.sendKeys("winter winter");
                alloverCommerceHomePage.signUp_Email.sendKeys("winter4@gfd.com");
                alloverCommerceHomePage.signUp_Password.sendKeys("Winter+winter+winter");
                //alloverCommerceHomePage.signUp_PrivacyPolicyCheckbox.click();
                alloverCommerceHomePage.signUp_Button.click();
                WaitUtils.waitFor(2);
                alloverCommerceHomePage.signUp_Button.click();
                //ExtentReportUtils.passAndCaptureScreenshot("Cannot login without clicking 'i agree with Privacy Policy' checkbox");
                //BrowserUtils.verifyElementNotDisplayed(alloverCommerceHomePage.signOut_Link);
                Assert.assertFalse(alloverCommerceHomePage.signOut_Link.isDisplayed());


                Driver.closeDriver();

        }
}
